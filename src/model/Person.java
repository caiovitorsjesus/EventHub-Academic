package model;

import utils.ValidationUtils;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {

    private String cpf;
    private String name;
    private String email;
    private LocalDate birthDate;

    public Person(String cpf, String name, String email, LocalDate birthDate) {
        setCpf(cpf);
        setName(name);
        setEmail(email);
        setBirthDate(birthDate);
    }

    public abstract String getPersonRole();

    public int calculateAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        ValidationUtils.validateText(name, "Name");
        this.name = name;
    }

    public void setEmail(String email) {
        ValidationUtils.validateEmail(email);
        this.email = email;
    }

    public void setBirthDate(LocalDate birthDate) {
        ValidationUtils.validateBirthDate(birthDate);
        this.birthDate = birthDate;
    }

    public void setCpf(String cpf) {
        ValidationUtils.validateText(cpf, "CPF");
        this.cpf = cpf;
    }

    @Override
    public String toString() {

        return "Person{" +
                "cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + calculateAge() +
                '}';
    }
}