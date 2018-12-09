package com.crossover.compliance.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class UserDetail {
        private Assignment AssignmentObject;
        private String headline;
        private String summary;
        private float id;
        private String email;
        private String firstName;
        private String lastName;
        private String fullName;
        private String photoUrl;
        private ManagerAvatar managerAvatar;

        private List< String > avatarTypes = new ArrayList< String >();
        Location LocationObject;
        private boolean infoShared;
        private String communicationStatus;

        public Assignment getAssignmentObject() {
                return AssignmentObject;
        }

        public void setAssignmentObject(Assignment assignmentObject) {
                AssignmentObject = assignmentObject;
        }

        public String getHeadline() {
                return headline;
        }

        public void setHeadline(String headline) {
                this.headline = headline;
        }

        public String getSummary() {
                return summary;
        }

        public void setSummary(String summary) {
                this.summary = summary;
        }

        public float getId() {
                return id;
        }

        public void setId(float id) {
                this.id = id;
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

        public String getFullName() {
                return fullName;
        }

        public void setFullName(String fullName) {
                this.fullName = fullName;
        }

        public String getPhotoUrl() {
                return photoUrl;
        }

        public void setPhotoUrl(String photoUrl) {
                this.photoUrl = photoUrl;
        }

        public List<String> getAvatarTypes() {
                return avatarTypes;
        }

        public void setAvatarTypes(List<String> avatarTypes) {
                this.avatarTypes = avatarTypes;
        }

        public Location getLocationObject() {
                return LocationObject;
        }

        public void setLocationObject(Location locationObject) {
                LocationObject = locationObject;
        }

        public boolean isInfoShared() {
                return infoShared;
        }

        public void setInfoShared(boolean infoShared) {
                this.infoShared = infoShared;
        }

        public String getCommunicationStatus() {
                return communicationStatus;
        }

        public void setCommunicationStatus(String communicationStatus) {
                this.communicationStatus = communicationStatus;
        }

        public ManagerAvatar getManagerAvatar() {
                return managerAvatar;
        }

        public void setManagerAvatar(ManagerAvatar managerAvatar) {
                this.managerAvatar = managerAvatar;
        }
}

