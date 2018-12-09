package com.crossover.compliance.repository;

import com.crossover.compliance.domain.ComplianceRules;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComplianceRulesRepository extends MongoRepository<ComplianceRules, Integer> {

    void deleteAllByManagerId(int managerId);
    ComplianceRules findByManagerIdAndTeamId(int managerId, int teamId);

}
