package com.cadastro.aluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cadastro.aluno.model.Form;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {    
}
