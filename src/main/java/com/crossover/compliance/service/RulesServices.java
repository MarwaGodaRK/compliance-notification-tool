package com.crossover.compliance.service;

import com.crossover.compliance.model.ComplianceRules;
import com.crossover.compliance.repository.ComplianceRulesRepository;
import com.crossover.compliance.security.SecurityUserDetails;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class RulesServices {

    @Autowired
    ComplianceRulesRepository complianceRulesRepository;
    @Autowired
    SecurityContextService securityContextService;

    public void addComplianceRules(ComplianceRules complianceRules){

        List<com.crossover.compliance.domain.ComplianceRules> domainComplianceRulesList =
                mapComplianceRulesToDomainObject(complianceRules);
        complianceRulesRepository.insert(domainComplianceRulesList);
    }

    public com.crossover.compliance.domain.ComplianceRules getComplianceRules(int managerId, int teamId){
        return complianceRulesRepository.findByManagerIdAndTeamId(managerId, teamId);
    }

    public void removeLoggedInUserComplianceRules(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityUserDetails userDetails = (SecurityUserDetails)authentication.getPrincipal();
        complianceRulesRepository.deleteAllByManagerId(userDetails.getUserId());
    }

    private List<com.crossover.compliance.domain.ComplianceRules> mapComplianceRulesToDomainObject(
            ComplianceRules complianceRules) {
        SecurityUserDetails securityUserDetails = securityContextService.getSessionUser();
        List<com.crossover.compliance.domain.ComplianceRules> complianceRulesList = new ArrayList<>();
        for (Integer teamId : securityUserDetails.getTeamIdList()) {
            com.crossover.compliance.domain.ComplianceRules domainComplianceRules =
                    new com.crossover.compliance.domain.ComplianceRules();
            domainComplianceRules.setManagerId(securityUserDetails.getUserId());
            domainComplianceRules.setTeamId(teamId);
            domainComplianceRules.setStopsCount(complianceRules.getStopsCount());
            domainComplianceRules.setMaximumAllowedTimeToStartWork(complianceRules.getMaximumAllowedTimeToStartWork());
            domainComplianceRules.setMinimumDailyAllowedHours(complianceRules.getMinimumDailyAllowedHours());
            domainComplianceRules.setMaximumAllowedOtherPercentage(complianceRules.getMaximumAllowedOtherPercentage());
            domainComplianceRules.setMaximumAllowedDistractionPercentage(complianceRules.getMaximumAllowedDistractionPercentage());
            domainComplianceRules.setDevelopmentPercentage(complianceRules.getDevelopmentPercentage());
            domainComplianceRules.setIntensityPercentage(complianceRules.getIntensityPercentage());
            domainComplianceRules.setFocusPercentage(complianceRules.getFocusPercentage());
            complianceRulesList.add(domainComplianceRules);
        }
        return complianceRulesList;
    }
}
