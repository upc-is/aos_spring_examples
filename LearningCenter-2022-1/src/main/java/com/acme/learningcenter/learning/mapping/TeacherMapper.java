package com.acme.learningcenter.learning.mapping;

import com.acme.learningcenter.learning.domain.model.entity.Teacher;
import com.acme.learningcenter.learning.resource.CreateTeacherResource;
import com.acme.learningcenter.learning.resource.TeacherResource;
import com.acme.learningcenter.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.validation.Validator;
import java.io.Serializable;

public class TeacherMapper implements Serializable {

  @Autowired
  EnhancedModelMapper mapper;

  public Teacher toModel(CreateTeacherResource resource) {

    return mapper.map(resource, Teacher.class);
  }

  public TeacherResource toResource(Teacher model) {
    return mapper.map(model, TeacherResource.class);
  }
}
