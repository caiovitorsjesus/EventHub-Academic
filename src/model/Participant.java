package model;

import enums.PersonType;

import java.time.LocalDate;
import java.util.List;

public class Participant extends Person{
    private String registrationNumber;
    private PersonType PersonType;

    private List<Activity> attendedActivities;


    public Participant(String cpf, LocalDate birthDate, String email, String name, String registrationNumber, PersonType personType) {
        super(cpf, birthDate, email, name);
    }

    @Override
    public void getPersonType() {
    }
}
