package com.crossover.compliance.model;

import java.util.ArrayList;
import java.util.List;

public class AdvancedGroup {
    private String sectionName;
    private String color;
    List< GroupItem > groupItems = new ArrayList < > ();
    private float spentTime;


    // Getter Methods

    public String getSectionName() {
        return sectionName;
    }

    public String getColor() {
        return color;
    }

    public float getSpentTime() {
        return spentTime;
    }

    // Setter Methods

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSpentTime(float spentTime) {
        this.spentTime = spentTime;
    }

    public List<GroupItem> getGroupItems() {
        return groupItems;
    }

    public void setGroupItems(List<GroupItem> groupItems) {
        this.groupItems = groupItems;
    }
}
