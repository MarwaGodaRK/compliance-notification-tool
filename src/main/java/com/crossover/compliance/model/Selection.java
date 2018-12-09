package com.crossover.compliance.model;

public class Selection {
    private float id;
    private String status;
    MarketplaceMember MarketplaceMemberObject;


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public MarketplaceMember getMarketplaceMember() {
        return MarketplaceMemberObject;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMarketplaceMember(MarketplaceMember marketplaceMemberObject) {
        this.MarketplaceMemberObject = marketplaceMemberObject;
    }
}