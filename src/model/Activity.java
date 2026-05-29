package model;

import utils.ValidationUtils;

import java.util.HashSet;
import java.util.Set;

public abstract class Activity {

    private String code;
    private String title;
    private int workloadHours;
    private int maxCapacity;

    private Speaker speaker;

    private Set<Participant> participants;

    public Activity(String code, String title, int workloadHours, int maxCapacity, Speaker speaker) {
        setCode(code);
        setTitle(title);
        setWorkloadHours(workloadHours);
        setMaxCapacity(maxCapacity);
        setSpeaker(speaker);
        participants = new HashSet<>();
    }

    public abstract double calculateCost();

    public abstract String getActivityType();

    public boolean registerParticipant(Participant participant) {
        if (participants.size() >= maxCapacity) {
            return false;
        }
        boolean added = participants.add(participant);
        if (added) {
            participant.addActivity(this);
        }
        return added;
    }

    public int getAvailableSpots() {
        return maxCapacity - participants.size();
    }

    public double calculateOccupancyRate() {
        return ((double) participants.size() / maxCapacity) * 100;
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

    public void setTitle(String title) {
        ValidationUtils.validateText(title, "Title");
        this.title = title;
    }

    public void setCode(String code) {
        ValidationUtils.validateText(code, "Code");
        this.code = code;
    }

    public void setWorkloadHours(int workloadHours) {
        if (workloadHours <= 0) {
            throw new IllegalArgumentException("Workload hours must be greater than 0.");
        }
        this.workloadHours = workloadHours;
    }

    public void setMaxCapacity(int maxCapacity) {
        ValidationUtils.validateCapacity(maxCapacity);
        this.maxCapacity = maxCapacity;
    }

    public void setSpeaker(Speaker speaker) {
        if (speaker == null) {
            throw new IllegalArgumentException("Speaker cannot be null.");
        }
        this.speaker = speaker;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    @Override
    public String toString() {
        return "Activity: " +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", type='" + getActivityType() + '\'' +
                ", workloadHours=" + workloadHours +
                ", availableSpots=" + getAvailableSpots();
    }
}