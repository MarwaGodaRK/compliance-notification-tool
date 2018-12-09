package com.crossover.compliance.model;

public class IcCompliance {

    private ComplianceTypes complianceType;
    private double actualValue;
    private double expectedValue;

    public ComplianceTypes getComplianceType() {
        return complianceType;
    }

    public void setComplianceType(ComplianceTypes complianceType) {
        this.complianceType = complianceType;
    }

    public double getActualValue() {
        return actualValue;
    }

    public void setActualValue(double actualValue) {
        this.actualValue = actualValue;
    }

    public double getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(double expectedValue) {
        this.expectedValue = expectedValue;
    }
}
