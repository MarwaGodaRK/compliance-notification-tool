package com.crossover.compliance.model;


public class Activity {

    Grouping GroupingObject;
    AssignmentHistory AssignmentHistoryObject;
    Assignment AssignmentObject;
    DayActivitiesTime DayActivitiesTimeObject;

// Getter Methods

    public Grouping getGrouping() {
        return GroupingObject;
    }

    public AssignmentHistory getAssignmentHistory() {
        return AssignmentHistoryObject;
    }

    public Assignment getAssignment() {
        return AssignmentObject;
    }

    public DayActivitiesTime getDayActivitiesTime() {
        return DayActivitiesTimeObject;
    }

// Setter Methods

    public void setGrouping(Grouping groupingObject) {
        this.GroupingObject = groupingObject;
    }

    public void setAssignmentHistory(AssignmentHistory assignmentHistoryObject) {
        this.AssignmentHistoryObject = assignmentHistoryObject;
    }

    public void setAssignment(Assignment assignmentObject) {
        this.AssignmentObject = assignmentObject;
    }

    public void setDayActivitiesTime(DayActivitiesTime dayActivitiesTimeObject) {
        this.DayActivitiesTimeObject = dayActivitiesTimeObject;
    }
}

