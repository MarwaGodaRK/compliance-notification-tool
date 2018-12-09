package com.crossover.compliance.model;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private float id;
    Candidate CandidateObject;
    private String status;
    List< Object > files = new ArrayList <  > ();
    List < Object > testScores = new ArrayList <  > ();
    private float score;
    private float yearsOfExperience;
    private String highestEducationLevel;
    private boolean termsAccepted;
    List < Object > variants = new ArrayList <  > ();


    // Getter Methods

    public float getId() {
        return id;
    }

    public Candidate getCandidate() {
        return CandidateObject;
    }

    public String getStatus() {
        return status;
    }

    public float getScore() {
        return score;
    }

    public float getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getHighestEducationLevel() {
        return highestEducationLevel;
    }

    public boolean getTermsAccepted() {
        return termsAccepted;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setCandidate(Candidate candidateObject) {
        this.CandidateObject = candidateObject;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void setYearsOfExperience(float yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setHighestEducationLevel(String highestEducationLevel) {
        this.highestEducationLevel = highestEducationLevel;
    }

    public void setTermsAccepted(boolean termsAccepted) {
        this.termsAccepted = termsAccepted;
    }
}