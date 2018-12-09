package com.crossover.compliance.model;

public class Company {
    private float id;
    private String name;
    private boolean internal;
    private float xoPercentage;
    private float currentBalance;


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getInternal() {
        return internal;
    }

    public float getXoPercentage() {
        return xoPercentage;
    }

    public float getCurrentBalance() {
        return currentBalance;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInternal(boolean internal) {
        this.internal = internal;
    }

    public void setXoPercentage(float xoPercentage) {
        this.xoPercentage = xoPercentage;
    }

    public void setCurrentBalance(float currentBalance) {
        this.currentBalance = currentBalance;
    }
}