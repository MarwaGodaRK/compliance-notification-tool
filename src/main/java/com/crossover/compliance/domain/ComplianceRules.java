package com.crossover.compliance.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;

@Data
@CompoundIndexes({
        @CompoundIndex(name = "manager_team", def = "{'managerId' : 1, 'teamId': 1}")
})
public class ComplianceRules {

    private int managerId;
    private int teamId;
    private int stopsCount;
    private int maximumAllowedTimeToStartWork;
    private int minimumDailyAllowedHours;
    private int maximumAllowedOtherPercentage;
    private int maximumAllowedDistractionPercentage;
    private int developmentPercentage;
    private int intensityPercentage;
    private int focusPercentage;

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getStopsCount() {
        return stopsCount;
    }

    public void setStopsCount(int stopsCount) {
        this.stopsCount = stopsCount;
    }

    public int getMaximumAllowedTimeToStartWork() {
        return maximumAllowedTimeToStartWork;
    }

    public void setMaximumAllowedTimeToStartWork(int maximumAllowedTimeToStartWork) {
        this.maximumAllowedTimeToStartWork = maximumAllowedTimeToStartWork;
    }

    public int getMinimumDailyAllowedHours() {
        return minimumDailyAllowedHours;
    }

    public void setMinimumDailyAllowedHours(int minimumDailyAllowedHours) {
        this.minimumDailyAllowedHours = minimumDailyAllowedHours;
    }

    public int getMaximumAllowedOtherPercentage() {
        return maximumAllowedOtherPercentage;
    }

    public void setMaximumAllowedOtherPercentage(int maximumAllowedOtherPercentage) {
        this.maximumAllowedOtherPercentage = maximumAllowedOtherPercentage;
    }

    public int getMaximumAllowedDistractionPercentage() {
        return maximumAllowedDistractionPercentage;
    }

    public void setMaximumAllowedDistractionPercentage(int maximumAllowedDistractionPercentage) {
        this.maximumAllowedDistractionPercentage = maximumAllowedDistractionPercentage;
    }

    public int getDevelopmentPercentage() {
        return developmentPercentage;
    }

    public void setDevelopmentPercentage(int developmentPercentage) {
        this.developmentPercentage = developmentPercentage;
    }

    public int getIntensityPercentage() {
        return intensityPercentage;
    }

    public void setIntensityPercentage(int intensityPercentage) {
        this.intensityPercentage = intensityPercentage;
    }

    public int getFocusPercentage() {
        return focusPercentage;
    }

    public void setFocusPercentage(int focusPercentage) {
        this.focusPercentage = focusPercentage;
    }
}
