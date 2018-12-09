package com.crossover.compliance.model;

import java.util.ArrayList;
import java.util.List;

public class Grouping {

    private float periodLong;
    private float totalTrackedTime;
    private float alignmentScore;
    List<AdvancedGroup> advancedGroups = new ArrayList<>();
    private float focusScore;
    private float intensityScore;

    // Getter Methods

    public float getPeriodLong() {
        return periodLong;
    }

    public float getTotalTrackedTime() {
        return totalTrackedTime;
    }

    public float getAlignmentScore() {
        return alignmentScore;
    }

    public float getFocusScore() {
        return focusScore;
    }

    public float getIntensityScore() {
        return intensityScore;
    }

    // Setter Methods

    public void setPeriodLong(float periodLong) {
        this.periodLong = periodLong;
    }

    public void setTotalTrackedTime(float totalTrackedTime) {
        this.totalTrackedTime = totalTrackedTime;
    }

    public void setAlignmentScore(float alignmentScore) {
        this.alignmentScore = alignmentScore;
    }

    public void setFocusScore(float focusScore) {
        this.focusScore = focusScore;
    }

    public void setIntensityScore(float intensityScore) {
        this.intensityScore = intensityScore;
    }

    public List<AdvancedGroup> getAdvancedGroups() {
        return advancedGroups;
    }

    public void setAdvancedGroups(List<AdvancedGroup> advancedGroups) {
        this.advancedGroups = advancedGroups;
    }
}