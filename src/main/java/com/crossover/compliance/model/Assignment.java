package com.crossover.compliance.model;

import java.util.ArrayList;
import java.util.List;

public class Assignment {
    private float id;
    Selection SelectionObject;
    CurrentAssignmentHistory CurrentAssignmentHistoryObject;
    private boolean trackerRequired;
    private String jobTitle;
    private float overtimeWarningHours;
    private String salaryType;
    private String salaryUnit;
    private String paymentPlatform;
    private float salary;
    Team TeamObject;
    Candidate CandidateObject;
    private float weeklyLimit;
    private String status;
    Manager ManagerObject;


    // Getter Methods

    public float getId() {
        return id;
    }

    public Selection getSelection() {
        return SelectionObject;
    }

    public CurrentAssignmentHistory getCurrentAssignmentHistory() {
        return CurrentAssignmentHistoryObject;
    }

    public boolean getTrackerRequired() {
        return trackerRequired;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public float getOvertimeWarningHours() {
        return overtimeWarningHours;
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

    public float getSalary() {
        return salary;
    }

    public Team getTeam() {
        return TeamObject;
    }

    public Candidate getCandidate() {
        return CandidateObject;
    }

    public float getWeeklyLimit() {
        return weeklyLimit;
    }

    public String getStatus() {
        return status;
    }

    public Manager getManager() {
        return ManagerObject;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setSelection(Selection selectionObject) {
        this.SelectionObject = selectionObject;
    }

    public void setCurrentAssignmentHistory(CurrentAssignmentHistory currentAssignmentHistoryObject) {
        this.CurrentAssignmentHistoryObject = currentAssignmentHistoryObject;
    }

    public void setTrackerRequired(boolean trackerRequired) {
        this.trackerRequired = trackerRequired;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setOvertimeWarningHours(float overtimeWarningHours) {
        this.overtimeWarningHours = overtimeWarningHours;
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

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setTeam(Team teamObject) {
        this.TeamObject = teamObject;
    }

    public void setCandidate(Candidate candidateObject) {
        this.CandidateObject = candidateObject;
    }

    public void setWeeklyLimit(float weeklyLimit) {
        this.weeklyLimit = weeklyLimit;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setManager(Manager managerObject) {
        this.ManagerObject = managerObject;
    }
}