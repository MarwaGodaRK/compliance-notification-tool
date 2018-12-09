package com.crossover.compliance.model;


import java.util.ArrayList;
import java.util.List;

public class Candidate {
    private String type;
    private long id;
    private long averageRatings;
    private long workedHours;
    private long billedHours;
    List< Object > languages = new ArrayList <  > ();
    List < Object > certifications = new ArrayList <  > ();
    List < Object > educations = new ArrayList <  > ();
    List < Object > employments = new ArrayList <  > ();
    List < Object > connections = new ArrayList <  > ();
    List < Object > skills = new ArrayList <  > ();
    private String skypeId;
    private boolean agreementAccepted;
    private String email;
    private boolean candidate;
    private String printableName;
    private boolean personal;
    Location location;
    private String photoUrl;
    List < Object > userAvatars = new ArrayList <  > ();
    List < Object > appFeatures = new ArrayList <  > ();
    List < Object > avatarTypes = new ArrayList <  > ();
    private String firstName;
    private String lastName;
    private boolean manager;
    private long userId;
    private boolean companyAdmin;
    List < Object > busySlots = new ArrayList <  > ();


    // Getter Methods

    public String getType() {
        return type;
    }

    public long getId() {
        return id;
    }

    public long getAverageRatings() {
        return averageRatings;
    }

    public long getWorkedHours() {
        return workedHours;
    }

    public long getBilledHours() {
        return billedHours;
    }

    public String getSkypeId() {
        return skypeId;
    }

    public boolean getAgreementAccepted() {
        return agreementAccepted;
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

    public Location getLocation() {
        return location;
    }

    public String getPhotoUrl() {
        return photoUrl;
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

    public long getUserId() {
        return userId;
    }

    public boolean getCompanyAdmin() {
        return companyAdmin;
    }

    // Setter Methods

    public void setType(String type) {
        this.type = type;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAverageRatings(long averageRatings) {
        this.averageRatings = averageRatings;
    }

    public void setWorkedHours(long workedHours) {
        this.workedHours = workedHours;
    }

    public void setBilledHours(long billedHours) {
        this.billedHours = billedHours;
    }

    public void setSkypeId(String skypeId) {
        this.skypeId = skypeId;
    }

    public void setAgreementAccepted(boolean agreementAccepted) {
        this.agreementAccepted = agreementAccepted;
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

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
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

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setCompanyAdmin(boolean companyAdmin) {
        this.companyAdmin = companyAdmin;
    }
}
