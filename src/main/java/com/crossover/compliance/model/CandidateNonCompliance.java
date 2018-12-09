package com.crossover.compliance.model;

import java.util.List;

public class CandidateNonCompliance{

    private Candidate candidate;
    private List<IcCompliance> icComplianceList;

    public CandidateNonCompliance(Candidate candidate,
            List<IcCompliance> icComplianceList) {
        this.candidate = candidate;
        this.icComplianceList = icComplianceList;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public List<IcCompliance> getIcComplianceList() {
        return icComplianceList;
    }

    public void setIcComplianceList(List<IcCompliance> icComplianceList) {
        this.icComplianceList = icComplianceList;
    }
}
