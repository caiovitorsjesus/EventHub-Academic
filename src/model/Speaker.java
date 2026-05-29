package model;

import java.time.LocalDate;

public class Speaker extends Person {
    private String academicDegree;
    private String specializationArea;

    public Speaker(String cpf, LocalDate birthDate, String email, String name, String academicDegree, String specializationArea) {
        super(cpf, birthDate, email, name);
    }
    public String getAcademicDegree() {
        return academicDegree;
    }
    public void setAcademicDegree(String academicDegree) {
        if (academicDegree == null || academicDegree.trim().isEmpty()){
            throw new IllegalArgumentException("Academic degree cannot be empty");
        }
        this.academicDegree = academicDegree.trim();
    }
    public String getSpecializationArea() {
        return specializationArea;
    }
    public void setSpecializationArea(String specializationArea) {
        if (specializationArea == null || specializationArea.trim().isEmpty()){
            throw new IllegalArgumentException("Specialization area cannot be empty");
        }
        this.specializationArea = specializationArea.trim();
    }
    @Override
    public void getPersonType() {
    }
}
