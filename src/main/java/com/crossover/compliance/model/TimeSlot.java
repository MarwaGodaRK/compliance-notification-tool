package com.crossover.compliance.model;

public class TimeSlot {
    private float index;
    private float appId;
    private String actName;
    private String color;
    private String appName;


    // Getter Methods

    public float getIndex() {
        return index;
    }

    public float getAppId() {
        return appId;
    }

    public String getActName() {
        return actName;
    }

    public String getColor() {
        return color;
    }

    public String getAppName() {
        return appName;
    }

    // Setter Methods

    public void setIndex(float index) {
        this.index = index;
    }

    public void setAppId(float appId) {
        this.appId = appId;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
