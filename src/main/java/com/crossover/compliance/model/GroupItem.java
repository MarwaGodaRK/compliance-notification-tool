package com.crossover.compliance.model;

public class GroupItem {
    private String applicationName;
    private float applicationId;
    private String categoryColor;
    private float spentTime;


    // Getter Methods

    public String getApplicationName() {
        return applicationName;
    }

    public float getApplicationId() {
        return applicationId;
    }

    public String getCategoryColor() {
        return categoryColor;
    }

    public float getSpentTime() {
        return spentTime;
    }

    // Setter Methods

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public void setApplicationId(float applicationId) {
        this.applicationId = applicationId;
    }

    public void setCategoryColor(String categoryColor) {
        this.categoryColor = categoryColor;
    }

    public void setSpentTime(float spentTime) {
        this.spentTime = spentTime;
    }
}