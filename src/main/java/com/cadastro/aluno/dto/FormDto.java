package com.cadastro.aluno.dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class FormDto {

    public FormDto(){
    }

    public FormDto(Long id, String name, LocalDate birthdate, String mother, String father, int ddd, String phone, String email,
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

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max=100, message="Máximo de 100 caracteres para o Nome")
    private String name;

    @NotNull(message = "Data de Nascimento é obrigatório")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthdate;

    @NotBlank(message = "Nome da mãe é obrigatório")
    @Size(max=100, message="Máximo de 100 caracteres para o Nome da Mãe")
    private String mother;

    @NotBlank(message = "Nome do pai é obrigatório")
    @Size(max=100, message="Máximo de 100 caracteres para o Nome do Pai")
    private String father;

    @NotNull(message = "DDD é obrigatório")
    private int ddd;

    @NotBlank(message = "Telefone é obrigatório")
    @Size(min=9, max=10, message = "Telefone tem que conter os 9 dígitos")
    @Pattern(regexp = "\\d{4,5}-\\d{4}", message = "Telefone tem que ter o ' - ' ")
    private String phone;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "Série é obrigatório")
    private String grade;

    @NotBlank(message = "Turno é obrigatório")
    private String shift;

    @Size(max=3, message="Máximo de 3 atividades extracurriculares")
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
