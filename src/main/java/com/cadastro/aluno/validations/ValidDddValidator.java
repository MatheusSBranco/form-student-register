package com.cadastro.aluno.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class ValidDddValidator implements ConstraintValidator<ValidDdd, String> {

    private String[] validDdds;

    @Override
    public void initialize(ValidDdd constraintAnnotation) {
        validDdds = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return Arrays.asList(validDdds).contains(value);
    }
}

