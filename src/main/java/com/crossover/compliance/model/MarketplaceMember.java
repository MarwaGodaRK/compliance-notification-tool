package com.crossover.compliance.model;


public class MarketplaceMember {
    private float id;
    Application ApplicationObject;
    private String activeOn;
    private String status;


    // Getter Methods

    public float getId() {
        return id;
    }

    public Application getApplication() {
        return ApplicationObject;
    }

    public String getActiveOn() {
        return activeOn;
    }

    public String getStatus() {
        return status;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setApplication(Application applicationObject) {
        this.ApplicationObject = applicationObject;
    }

    public void setActiveOn(String activeOn) {
        this.activeOn = activeOn;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
