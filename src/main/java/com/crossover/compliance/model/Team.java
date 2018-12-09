package com.crossover.compliance.model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private int id;
    private String name;
    Company CompanyObject;
    List< Object > metricsSetups = new ArrayList <  > ();
    private boolean deleted;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return CompanyObject;
    }

    public boolean getDeleted() {
        return deleted;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company companyObject) {
        this.CompanyObject = companyObject;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}