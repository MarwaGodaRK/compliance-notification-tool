package com.crossover.compliance.model;


public class TimeZone {
    private int id;
    private String name;
    private float standardOffset;
    private String hourlyOffset;
    private float offset;


    // Getter Methods

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getStandardOffset() {
        return standardOffset;
    }

    public String getHourlyOffset() {
        return hourlyOffset;
    }

    public float getOffset() {
        return offset;
    }

    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStandardOffset(float standardOffset) {
        this.standardOffset = standardOffset;
    }

    public void setHourlyOffset(String hourlyOffset) {
        this.hourlyOffset = hourlyOffset;
    }

    public void setOffset(float offset) {
        this.offset = offset;
    }

}
