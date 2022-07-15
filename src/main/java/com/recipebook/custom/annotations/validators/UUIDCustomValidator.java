package com.recipebook.custom.annotations.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.regex.Pattern;

public class UUIDCustomValidator implements ConstraintValidator<UUID, java.util.UUID> {

    public static final String UUID_V4_STRING =
            "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-4[a-fA-F0-9]{3}-[89abAB][a-fA-F0-9]{3}-[a-fA-F0-9]{12}";

    public static final Pattern UUID_V4 = Pattern.compile(UUID_V4_STRING);

    @Override
    public void initialize(UUID constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(java.util.UUID uuid, ConstraintValidatorContext constraintValidatorContext) {

        if(Objects.isNull(uuid)) return false;

        return UUID_V4.matcher(uuid.toString()).find();
    }
}
