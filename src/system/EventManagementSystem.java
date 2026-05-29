package system;

import model.*;
import utils.ValidationUtils;

import java.util.*;

public class EventManagementSystem {

    private String eventName;

    private Map<String, Participant> participants;
    private Map<String, Speaker> speakers;

    private List<Activity> activities;

    private String[] operatingDays;

    public EventManagementSystem(String eventName, String[] operatingDays) {
        this.eventName = eventName;
        this.operatingDays = operatingDays;
        participants = new HashMap<>();
        speakers = new HashMap<>();
        activities = new ArrayList<>();
    }

    public boolean registerParticipant(Participant participant) {
        if (participants.containsKey(participant.getRegistrationNumber())) {
            return false;
        }
        participants.put(participant.getRegistrationNumber(), participant);
        return true;
    }

    public boolean registerSpeaker(Speaker speaker) {
        if (speakers.containsKey(speaker.getCpf())) {
            return false;
        }
        speakers.put(speaker.getCpf(), speaker);
        return true;
    }

    public boolean registerActivity(Activity activity) {
        return activities.add(activity);
    }

    public Participant findParticipant(String registration) {
        return participants.get(registration);
    }

    public Speaker findSpeaker(String cpf) {
        return speakers.get(cpf);
    }

    public Activity findActivity(String code) {
        for (Activity activity : activities) {
            if (activity.getCode().equals(code)) {
                return activity;
            }
        }
        return null;
    }

    public boolean enrollParticipant(String registration, String activityCode) {
        Participant participant = findParticipant(registration);
        Activity activity = findActivity(activityCode);
        if (participant == null || activity == null) {
            return false;
        }
        return activity.registerParticipant(participant);
    }

    public double calculateTotalRevenue() {
        double total = 0;
        for (Activity activity : activities) {
            total += activity.calculateCost() * activity.getParticipants().size();
        }
        return total;
    }

    public void listActivities() {
        System.out.println("\n=== ACTIVITIES ===");
        for (Activity activity : activities) {
            System.out.println(activity);
        }
    }

    public void listParticipants() {
        System.out.println("\n=== PARTICIPANTS ===");
        for (Participant participant : participants.values()) {
            System.out.println(participant);
        }
    }

    public void listSpeakers() {
        System.out.println("\n=== SPEAKERS ===");
        for (Speaker speaker : speakers.values()) {
            System.out.println(speaker);
        }
    }

    public String getEventName() {
        return eventName;
    }

    public String[] getOperatingDays() {
        return operatingDays;
    }

    public void setEventName(String eventName) {
        ValidationUtils.validateText(eventName, "Event Name");
        this.eventName = eventName;
    }

    public void setOperatingDays(String[] operatingDays) {
        if (operatingDays == null || operatingDays.length == 0) {
            throw new IllegalArgumentException("Operating days cannot be empty.");
        }
        this.operatingDays = operatingDays;
    }
}