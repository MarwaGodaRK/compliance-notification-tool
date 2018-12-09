package com.crossover.compliance.model;

import lombok.Data;

@Data
public class ComplianceRules {

    private int stopsCount;
    private int maximumAllowedTimeToStartWork;
    private int minimumDailyAllowedHours;
    private int maximumAllowedOtherPercentage;
    private int maximumAllowedDistractionPercentage;
    private int developmentPercentage;
    private int intensityPercentage;
    private int focusPercentage;

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
