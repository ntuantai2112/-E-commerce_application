package com.fpoly.myspringbootapp.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class AgeValidator implements ConstraintValidator<AgeConstraint, Integer> {

    private int min;
    private int max;

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {

        if (Objects.isNull(value)) {
            return true;
        }

        return value >= min && value < 100;
    }

    @Override
    public void initialize(AgeConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();


    }


}
