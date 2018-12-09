package com.crossover.compliance.model;

import java.util.ArrayList;
import java.util.List;

public class DayActivitiesTime {
    List<TimeSlot> contractorTimeSlots = new ArrayList <  > ();
    List <TimeSlot> managerTimeSlots = new ArrayList <  > ();

    public List<TimeSlot> getContractorTimeSlots() {
        return contractorTimeSlots;
    }

    public void setContractorTimeSlots(ArrayList<TimeSlot> contractorTimeSlots) {
        this.contractorTimeSlots = contractorTimeSlots;
    }

    public List<TimeSlot> getManagerTimeSlots() {
        return managerTimeSlots;
    }

    public void setManagerTimeSlots(ArrayList<TimeSlot> managerTimeSlots) {
        this.managerTimeSlots = managerTimeSlots;
    }
}