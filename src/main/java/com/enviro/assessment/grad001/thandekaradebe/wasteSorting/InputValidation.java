package com.enviro.assessment.grad001.thandekaradebe.wasteSorting;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;


import java.util.Set;

public class InputValidation {
    private static final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = validatorFactory.getValidator();

    public static <T> Set<ConstraintViolation<T>> validate(T object) {
        return validator.validate(object);
    }
}
