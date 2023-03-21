package com.cadastro.aluno.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Form {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min=1, max=100)
    private String name;

    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthdate;

    @NotBlank
    @Size(min=1, max=100)
    private String mother;

    @NotNull
    @Size(min=1, max=100)
    private String father;

    @NotNull
    private int ddd;

    @NotNull
    @Size(min=1, max=20)
    @Pattern(regexp = "\\d{4,5}-\\d{4}")
    private String phone;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min=1, max=100)
    private String grade;

    @NotNull
    @Size(min=1, max=100)
    private String shift;

    @Size(max=3)
    private List<String> extracurricular;    

    public Form(Long id, String name, LocalDate birthdate, String mother, String father, int ddd, String phone, String email,
            String grade, String shift, List<String> extracurricular) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.mother = mother;
        this.father = father;
        this.ddd = ddd;
        this.phone = phone;
        this.email = email;
        this.grade = grade;
        this.shift = shift;
        this.extracurricular = extracurricular;
    }

    public Form(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public List<String> getExtracurricular() {
        return extracurricular;
    }

    public void setExtracurricular(List<String> extracurricular) {
        this.extracurricular = extracurricular;
    }
}
