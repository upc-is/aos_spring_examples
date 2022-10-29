package com.acme.learningcenter.learning.service;

import com.acme.learningcenter.learning.domain.model.entity.Student;
import com.acme.learningcenter.learning.domain.model.entity.Teacher;
import com.acme.learningcenter.learning.domain.persistence.TeacherRepository;
import com.acme.learningcenter.learning.domain.service.TeacherService;
import com.acme.learningcenter.shared.exception.ResourceValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

  private static final String ENTITY = "Teacher";
  private final TeacherRepository teacherRepository;
  private final Validator validator;

  @Override
  public List<Teacher> getAll() {
    return teacherRepository.findAll();
  }

  @Override
  public Teacher create(Teacher teacher) {
    // Validating teacher object
    Set<ConstraintViolation<Teacher>> violations = validator.validate(teacher);

    if (!violations.isEmpty()) {
      throw new ResourceValidationException(ENTITY, violations);
    }

    // Dni Uniqueness validation
    Teacher teacherWithDni = teacherRepository.findByDni(teacher.getDni());
    if (teacherWithDni != null) {
      throw new ResourceValidationException(ENTITY,
              "An teacher with the same dni already exists.");
    }

    return teacherRepository.save(teacher);
  }
}
