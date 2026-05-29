package model;

import enums.PersonType;
import utils.ValidationUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Participant extends Person {

    private String registrationNumber;
    private PersonType personType;

    private List<Activity> attendedActivities;

    public Participant(String cpf, String name, String email, LocalDate birthDate, String registrationNumber, PersonType personType) {
        super(cpf, name, email, birthDate);
        setRegistrationNumber(registrationNumber);
        setPersonType(personType);
        attendedActivities = new ArrayList<>();
    }

    @Override
    public String getPersonRole() {
        return "Participant";
    }

    public boolean addActivity(Activity activity) {
        return attendedActivities.add(activity);
    }

    public int calculateTotalHours() {
        int total = 0;
        for (Activity activity : attendedActivities) {
            total += activity.getWorkloadHours();
        }
        return total;
    }

    public double calculateTotalCost() {
        double total = 0;
        for (Activity activity : attendedActivities) {
            total += activity.calculateCost();
        }
        return total;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public List<Activity> getAttendedActivities() {
        return attendedActivities;
    }

    public void setRegistrationNumber(String registrationNumber) {
        ValidationUtils.validateText(registrationNumber, "Registration Number");
        this.registrationNumber = registrationNumber;
    }

    public void setPersonType(PersonType personType) {
        if (personType == null) {
            throw new IllegalArgumentException("Person type cannot be null.");
        }
        this.personType = personType;
    }

    @Override
    public String toString() {

        return "Participant{" +
                "name='" + getName() + '\'' +
                ", registration='" + registrationNumber + '\'' +
                ", type=" + personType +
                '}';
    }
}