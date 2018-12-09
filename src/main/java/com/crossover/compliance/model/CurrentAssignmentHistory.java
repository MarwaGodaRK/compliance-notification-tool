package com.crossover.compliance.model;


public class CurrentAssignmentHistory {
    private float id;
    Team TeamObject;
    Manager ManagerObject;
    private float salary;
    private String salaryType;
    private String salaryUnit;
    private String paymentPlatform;
    private float weeklyLimit;
    private String status;


    // Getter Methods

    public float getId() {
        return id;
    }

    public Team getTeam() {
        return TeamObject;
    }

    public Manager getManager() {
        return ManagerObject;
    }

    public float getSalary() {
        return salary;
    }

    public String getSalaryType() {
        return salaryType;
    }

    public String getSalaryUnit() {
        return salaryUnit;
    }

    public String getPaymentPlatform() {
        return paymentPlatform;
    }

    public float getWeeklyLimit() {
        return weeklyLimit;
    }

    public String getStatus() {
        return status;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setTeam(Team teamObject) {
        this.TeamObject = teamObject;
    }

    public void setManager(Manager managerObject) {
        this.ManagerObject = managerObject;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType;
    }

    public void setSalaryUnit(String salaryUnit) {
        this.salaryUnit = salaryUnit;
    }

    public void setPaymentPlatform(String paymentPlatform) {
        this.paymentPlatform = paymentPlatform;
    }

    public void setWeeklyLimit(float weeklyLimit) {
        this.weeklyLimit = weeklyLimit;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}