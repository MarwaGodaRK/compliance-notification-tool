package com.crossover.compliance.service;

import com.crossover.compliance.domain.ComplianceRules;
import com.crossover.compliance.domain.User;
import com.crossover.compliance.model.Activity;
import com.crossover.compliance.model.AdvancedGroup;
import com.crossover.compliance.model.Candidate;
import com.crossover.compliance.model.CandidateNonCompliance;
import com.crossover.compliance.model.ComplianceTypes;
import com.crossover.compliance.model.Grouping;
import com.crossover.compliance.model.IcCompliance;
import com.crossover.compliance.model.Manager;
import com.crossover.compliance.model.TimeSlot;
import com.crossover.compliance.repository.ComplianceRulesRepository;
import com.crossover.compliance.service.rest.RestClient;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    @Autowired
    UserService userService;
    @Autowired
    RulesServices rulesServices;
    @Autowired
    RestClient restClient;
    @Autowired
    ComplianceRulesRepository complianceRulesRepository;

    public Map<Integer, Map<Integer, List<Activity>>> getTeamTodayActivities(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String today = formatter.format(LocalDateTime.now());

        List<User> managers = userService.getManagers();

        return managers.stream().collect(Collectors.toMap( User::getUserId,
                m-> m.getTeamIds().stream().collect(Collectors.toMap(teamId -> teamId,
                teamId -> restClient.getTeamActivities(m.getToken(), m.getUserId(), teamId, today).getBody()))
        ));
    }

    public Map<Manager, List<CandidateNonCompliance>> extractTeamNonComplianceWithRules(
            Map<Integer, Map<Integer, List<Activity>>> managerTeamActivities) {
        return managerTeamActivities.entrySet().stream().map(
                entry -> entry.getValue().entrySet().stream().collect(
                        Collectors.toMap(team -> team.getValue().get(0).getAssignment().getManager(),
                                team -> {
                                    ComplianceRules teamComplianceRules = rulesServices
                                            .getComplianceRules(entry.getKey(), team.getKey());
                                    return team.getValue().stream().map(activity ->
                                            getNonCompliantMetrics(activity, teamComplianceRules)

                                    ).filter(candidateNonCompliance -> candidateNonCompliance.isPresent()).
                                            map(candidateNonCompliance -> candidateNonCompliance.get()).collect(Collectors.toList());
                                }
                        ))
        ).findFirst().get();
    }



    private Optional<CandidateNonCompliance> getNonCompliantMetrics(Activity activity,
            ComplianceRules teamComplianceRules) {
        List<IcCompliance> icComplianceList = new ArrayList<>();
        List<IcCompliance> icDailyActivityCompliance = getNonCompliantDailyActivitiesRatios(activity, teamComplianceRules);
        icComplianceList.addAll(icDailyActivityCompliance);
        Optional<IcCompliance> iCNumberOfStopsCompliance = getIcNonCompliantWithNoOfStops(activity, teamComplianceRules.getStopsCount());
        if(iCNumberOfStopsCompliance.isPresent()){
            icComplianceList.add(iCNumberOfStopsCompliance.get());
        }
        icComplianceList.addAll(getICsThatNeedsToStartWorkImmediately(activity, teamComplianceRules));
        Optional<IcCompliance> icComplianceWithIntensity = getICsWithLowIntensityAfterFourHours(activity, teamComplianceRules);
        if(icComplianceWithIntensity.isPresent()){
            icComplianceList.add(icComplianceWithIntensity.get());
        }
        Optional<IcCompliance> icComplianceWithFocus = getICsWithLowFocusAfterFourHours(activity, teamComplianceRules);
        if(icComplianceWithFocus.isPresent()){
            icComplianceList.add(icComplianceWithFocus.get());
        }
        if(icComplianceList.size() > 0) {
            CandidateNonCompliance candidateNonCompliance =
                    new CandidateNonCompliance(activity.getAssignment().getCandidate(), icComplianceList);

            return Optional.of(candidateNonCompliance);
        }
        return Optional.empty();
    }

    private List<IcCompliance> getNonCompliantDailyActivitiesRatios(Activity activity,
            ComplianceRules teamComplianceRules) {
        List<IcCompliance> icNonComplianceList = new ArrayList<>();
        Grouping grouping = activity.getGrouping();
        Optional<IcCompliance> devCompliance = collectIcNonComplianceWithExpectedPercentage(
                teamComplianceRules.getDevelopmentPercentage(), grouping, ComplianceTypes.DEV_PERCENTAGE,
                "Development");
        if(devCompliance.isPresent()){
            icNonComplianceList.add(devCompliance.get());
        }
        Optional<IcCompliance> otherCompliance = collectIcNonComplianceWithExpectedPercentage(
                teamComplianceRules.getMaximumAllowedOtherPercentage(), grouping, ComplianceTypes.MAX_OTHER_PERCENTAGE,
                "Other");
        if(otherCompliance.isPresent()){
            icNonComplianceList.add(otherCompliance.get());
        }
        Optional<IcCompliance> distractionCompliance = collectIcNonComplianceWithExpectedPercentage(
                teamComplianceRules.getMaximumAllowedDistractionPercentage(), grouping, ComplianceTypes.MAX_DISTRACTION_PERCENTAGE,
                "Distraction");
        if(distractionCompliance.isPresent()){
            icNonComplianceList.add(distractionCompliance.get());
        }
        return icNonComplianceList;
    }

    private Optional<IcCompliance> collectIcNonComplianceWithExpectedPercentage(int expectedActivityPercentage,
            Grouping grouping, ComplianceTypes complianceTypes, String activityGroup) {
        Optional<AdvancedGroup> activityAdvancedGroup = grouping.getAdvancedGroups().stream().
                filter(g->activityGroup.equals(g.getSectionName())).findFirst();
        if(activityAdvancedGroup.isPresent()) {
            float actualSpentTime = activityAdvancedGroup.get().getSpentTime();

            long actualTimeRatio = 0;
            if (grouping.getTotalTrackedTime() > 0) {
                actualTimeRatio = Math.round(actualSpentTime * 100 / grouping.getTotalTrackedTime());
            }
            if ((complianceTypes.equals(ComplianceTypes.DEV_PERCENTAGE) && actualTimeRatio < expectedActivityPercentage)
            || (!complianceTypes.equals(ComplianceTypes.DEV_PERCENTAGE) && actualTimeRatio >= expectedActivityPercentage)) {
                IcCompliance icCompliance = new IcCompliance();
                icCompliance.setComplianceType(complianceTypes);
                icCompliance.setActualValue(actualTimeRatio);
                icCompliance.setExpectedValue(expectedActivityPercentage);
                return Optional.of(icCompliance);
            }
        }
        return Optional.empty();
    }

    private Optional<IcCompliance> getIcNonCompliantWithNoOfStops(Activity activity, int stopsCount){

            List<TimeSlot> contractorTimeSlots = activity.getDayActivitiesTime().getContractorTimeSlots();
            int index = 0;
            int count = 0;
            for ( TimeSlot timeSlot : contractorTimeSlots){
                if((timeSlot == null && index >0 && contractorTimeSlots.get(index-1) != null) &&
                        (index <contractorTimeSlots.size()-1 &&contractorTimeSlots.get(index+1) == null)){
                    count++;
                }
                index++;
            }
            if(count >= stopsCount){
                IcCompliance icCompliance = new IcCompliance();
                icCompliance.setExpectedValue(stopsCount);
                icCompliance.setActualValue(count);
                icCompliance.setComplianceType(ComplianceTypes.STOPS_COUNT);
                return Optional.of(icCompliance);
            }
        return Optional.empty();
    }

    private List<IcCompliance> getICsThatNeedsToStartWorkImmediately(Activity activity,ComplianceRules teamCompliancerRules){

        List<IcCompliance> icComplianceList = new ArrayList<>();
            OffsetDateTime currentTimeInICTimeZone = getICDateTime(activity.getAssignment().getCandidate());
            if((currentTimeInICTimeZone.getHour() + 8 ) > 24 &&
                    (activity.getGrouping().getTotalTrackedTime() < teamCompliancerRules.getMinimumDailyAllowedHours())) {
                IcCompliance icCompliance = new IcCompliance();
                icCompliance.setComplianceType(ComplianceTypes.DAILY_MIN_HOURS);
                icCompliance.setActualValue(activity.getGrouping().getTotalTrackedTime());
                icCompliance.setExpectedValue(teamCompliancerRules.getMinimumDailyAllowedHours());
                icComplianceList.add(icCompliance);
            }else if (currentTimeInICTimeZone.getHour() >= teamCompliancerRules.getMaximumAllowedTimeToStartWork()
                    && activity.getGrouping().getTotalTrackedTime() <4){
                IcCompliance icCompliance = new IcCompliance();
                icCompliance.setComplianceType(ComplianceTypes.ALLOWED_TIME_TO_START_WORK);
                icCompliance.setActualValue(currentTimeInICTimeZone.getHour());
                icCompliance.setExpectedValue(teamCompliancerRules.getMaximumAllowedTimeToStartWork());
                icComplianceList.add(icCompliance);
            }
            return icComplianceList;

    }

    private OffsetDateTime getICDateTime(Candidate candidate) {
        Instant currentTimeUTC = Instant.now();
        return currentTimeUTC.atOffset(
                ZoneOffset.of(candidate.getLocation().getTimeZone().getHourlyOffset()));
    }

    private Optional<IcCompliance> getICsWithLowIntensityAfterFourHours(Activity activity, ComplianceRules complianceRules){

            if(activity.getGrouping().getIntensityScore() < complianceRules.getIntensityPercentage()
                    && activity.getGrouping().getTotalTrackedTime() >= 4 ){
                IcCompliance icCompliance = new IcCompliance();
                icCompliance.setComplianceType(ComplianceTypes.INTENSITY_PERCENTAGE);
                icCompliance.setActualValue(activity.getGrouping().getIntensityScore());
                icCompliance.setExpectedValue(complianceRules.getIntensityPercentage());
            }
            return Optional.empty();
    }

    private Optional<IcCompliance> getICsWithLowFocusAfterFourHours(Activity activity, ComplianceRules complianceRules){

        if(activity.getGrouping().getFocusScore() < complianceRules.getFocusPercentage()
                && activity.getGrouping().getTotalTrackedTime() >= 4 ){
            IcCompliance icCompliance = new IcCompliance();
            icCompliance.setComplianceType(ComplianceTypes.FOCUS_PERCENTAGE);
            icCompliance.setActualValue(activity.getGrouping().getFocusScore());
            icCompliance.setExpectedValue(complianceRules.getFocusPercentage());
        }
        return Optional.empty();
    }

}
