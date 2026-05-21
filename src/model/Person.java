package model;

import java.time.LocalDate;

public abstract class Person {
        private String cpf;
        private String name;
        private String email;
        private LocalDate birthDate;

    public Person(String cpf, LocalDate birthDate, String email, String name) {
        this.setCpf(cpf);
        this.setBirthDate(birthDate);
        this.setEmail(email);
        this.setName(name);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()){
            throw new IllegalArgumentException("CPF cannot be empty");
        }
        this.cpf = cpf.trim();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()){
            throw new IllegalArgumentException("Email cannot be empty");
        }
        this.email = email.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name.trim();
    }
    public abstract void getPersonType();
    public int calculateAge(){
        return LocalDate.now().getYear() - this.getBirthDate().getYear();
    };
}
