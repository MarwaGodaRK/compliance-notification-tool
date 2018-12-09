package com.crossover.compliance.security;

public class AuthenticationToken {

    private String token;
    private float appId;
    private float userId;

    // Getter Methods

    public String getToken() {
        return token;
    }

    public float getAppId() {
        return appId;
    }

    public float getUserId() {
        return userId;
    }

    // Setter Methods

    public void setToken(String token) {
        this.token = token;
    }

    public void setAppId(float appId) {
        this.appId = appId;
    }

    public void setUserId(float userId) {
        this.userId = userId;
    }
}
