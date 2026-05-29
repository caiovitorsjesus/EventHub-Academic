package model;

import java.util.Set;

public abstract class Activity {
    private String code;
    private String title;
    private int workloadHours;
    private int maxCapacity;
    private Speaker speaker;

    private Set<Participant> registeredParticipants;

    public Activity(String code, String title, int workloadHours, Speaker speaker, int maxCapacity) {
        this.code = code;
        this.title = title;
        this.workloadHours = workloadHours;
        this.speaker = speaker;
        this.maxCapacity = maxCapacity;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getWorkloadHours() {
        return workloadHours;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public Set<Participant> getRegisteredParticipants() {
        return registeredParticipants;
    }

    public abstract double calculateCost();
    public abstract String getActivityType();

    public boolean registerParticipant(Participant participant){
    }

    public int getAvailableSpots(){
    }

    public double getOccupancyRate(){
    }

    public int getRegisteredParticipantsCount(){
    }
}
