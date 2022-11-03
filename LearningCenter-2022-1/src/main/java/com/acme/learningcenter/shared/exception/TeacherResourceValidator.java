package com.acme.learningcenter.shared.exception;

import com.acme.learningcenter.learning.resource.CreateTeacherResource;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@AllArgsConstructor
public class TeacherResourceValidator {

    private static final String ENTITY = "Teacher";
    private final Validator validator;

    public void validate(CreateTeacherResource resource) {
        // Validating teacher object
        Set<ConstraintViolation<CreateTeacherResource>> violations = validator.validate(resource);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }
    }
}
