package com.cadastro.aluno.model;

import java.time.LocalDate;
import java.util.List;

import com.cadastro.aluno.dto.FormDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Form {

    public Form(Long id, String name, LocalDate birthdate, String mother, String father, String ddd, String phone, String email,
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
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private LocalDate birthdate;

    @Column
    private String mother;

    @Column
    private String father;

    @Column
    private String ddd;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String grade;

    @Column
    private String shift;

    @Column
    private List<String> extracurricular;    

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

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
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

    public static Form dtoToForm(FormDto formDto) {
        Form form = new Form();
        form.setId(formDto.getId());
        form.setName(formDto.getName());
        form.setBirthdate(formDto.getBirthdate());
        form.setMother(formDto.getMother());
        form.setFather(formDto.getFather());
        form.setDdd(formDto.getDdd());
        form.setPhone(formDto.getPhone());
        form.setEmail(formDto.getEmail());
        form.setGrade(formDto.getGrade());
        form.setShift(formDto.getShift());
        form.setExtracurricular(formDto.getExtracurricular());
        return form;
    }
}
