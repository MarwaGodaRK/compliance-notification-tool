package com.crossover.compliance.model;


import java.util.ArrayList;
import java.util.List;

public class Manager {
    private String type;
    private float id;
    List< Object > rejectedCandidates = new ArrayList <  > ();
    List < Object > availableSlots = new ArrayList <  > ();
    private boolean manualTimeNotificationsEnabled;
    private String email;
    private boolean candidate;
    private String printableName;
    private boolean personal;
    List < Object > userAvatars = new ArrayList <  > ();
    List < Object > appFeatures = new ArrayList <  > ();
    List < Object > avatarTypes = new ArrayList <  > ();
    private String firstName;
    private String lastName;
    private boolean manager;
    private float userId;
    private boolean companyAdmin;
    List < Object > busySlots = new ArrayList <  > ();
    Location LocationObject;


    // Getter Methods

    public String getType() {
        return type;
    }

    public float getId() {
        return id;
    }

    public boolean getManualTimeNotificationsEnabled() {
        return manualTimeNotificationsEnabled;
    }

    public String getEmail() {
        return email;
    }

    public boolean getCandidate() {
        return candidate;
    }

    public String getPrintableName() {
        return printableName;
    }

    public boolean getPersonal() {
        return personal;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean getManager() {
        return manager;
    }

    public float getUserId() {
        return userId;
    }

    public boolean getCompanyAdmin() {
        return companyAdmin;
    }

    public Location getLocation() {
        return LocationObject;
    }

    // Setter Methods

    public void setType(String type) {
        this.type = type;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setManualTimeNotificationsEnabled(boolean manualTimeNotificationsEnabled) {
        this.manualTimeNotificationsEnabled = manualTimeNotificationsEnabled;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCandidate(boolean candidate) {
        this.candidate = candidate;
    }

    public void setPrintableName(String printableName) {
        this.printableName = printableName;
    }

    public void setPersonal(boolean personal) {
        this.personal = personal;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public void setUserId(float userId) {
        this.userId = userId;
    }

    public void setCompanyAdmin(boolean companyAdmin) {
        this.companyAdmin = companyAdmin;
    }

    public void setLocation(Location locationObject) {
        this.LocationObject = locationObject;
    }
}
