package com.fpoly.myspringbootapp.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {AgeValidator.class})
public @interface AgeConstraint {
    String message() default "Invalid age";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int min();

    int max() default 100;

}
