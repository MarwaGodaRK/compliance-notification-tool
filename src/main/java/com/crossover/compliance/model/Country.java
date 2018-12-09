package com.crossover.compliance.model;


public class Country {

    private float id;
    private String name;
    private String code;
    private boolean allowed;

    public Country() {

    }

    public Country(String name) {
        this.name = name;
    }
    // Getter Methods

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public boolean getAllowed() {
        return allowed;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }
}