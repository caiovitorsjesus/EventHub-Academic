package model;

import utils.ValidationUtils;

import java.time.LocalDate;

public class Speaker extends Person {

    private String academicDegree;
    private String specializationArea;

    public Speaker(String cpf, String name, String email, LocalDate birthDate, String academicDegree, String specializationArea) {
        super(cpf, name, email, birthDate);
        setAcademicDegree(academicDegree);
        setSpecializationArea(specializationArea);
    }

    @Override
    public String getPersonRole() {
        return "Speaker";
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public String getSpecializationArea() {
        return specializationArea;
    }

    public void setSpecializationArea(String specializationArea) {
        ValidationUtils.validateText(specializationArea, "Specialization Area");
        this.specializationArea = specializationArea;
    }

    public void setAcademicDegree(String academicDegree) {
        ValidationUtils.validateText(academicDegree, "Academic Degree");
        this.academicDegree = academicDegree;
    }

    @Override
    public String toString() {

        return "Speaker{" +
                "name='" + getName() + '\'' +
                ", academicDegree='" + academicDegree + '\'' +
                ", specializationArea='" + specializationArea + '\'' +
                '}';
    }
}