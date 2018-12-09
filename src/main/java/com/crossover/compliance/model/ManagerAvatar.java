package com.crossover.compliance.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ManagerAvatar {

    private int id;
    private int userId;
    private String email;
    private String firstName;
    private String lastName;
    private String printableName;
    private String photoUrl;
    Location LocationObject;
    List<String> avatarTypes = new ArrayList<>();
    List<Object> userAvatars = new ArrayList<>();
    Company CompanyObject;
    private boolean feedbackRequired;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPrintableName() {
        return printableName;
    }

    public void setPrintableName(String printableName) {
        this.printableName = printableName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Location getLocationObject() {
        return LocationObject;
    }

    public void setLocationObject(Location locationObject) {
        LocationObject = locationObject;
    }

    public List<String> getAvatarTypes() {
        return avatarTypes;
    }

    public void setAvatarTypes(List<String> avatarTypes) {
        this.avatarTypes = avatarTypes;
    }

    public List<Object> getUserAvatars() {
        return userAvatars;
    }

    public void setUserAvatars(List<Object> userAvatars) {
        this.userAvatars = userAvatars;
    }

    public Company getCompanyObject() {
        return CompanyObject;
    }

    public void setCompanyObject(Company companyObject) {
        CompanyObject = companyObject;
    }

    public boolean isFeedbackRequired() {
        return feedbackRequired;
    }

    public void setFeedbackRequired(boolean feedbackRequired) {
        this.feedbackRequired = feedbackRequired;
    }
}
