package com.crossover.compliance.model;

import java.util.ArrayList;
import java.util.List;

public class Dashboard {
    List < Team > teams = new ArrayList<  >();
    List< Assignment > assignments = new ArrayList <  > ();


    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }
}