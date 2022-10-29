package com.acme.learningcenter.learning.api;

import com.acme.learningcenter.learning.domain.model.entity.Teacher;
import com.acme.learningcenter.learning.domain.service.StudentService;
import com.acme.learningcenter.learning.domain.service.TeacherService;
import com.acme.learningcenter.learning.mapping.StudentMapper;
import com.acme.learningcenter.learning.mapping.TeacherMapper;
import com.acme.learningcenter.learning.resource.CreateTeacherResource;
import com.acme.learningcenter.learning.resource.TeacherResource;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/teachers", produces = "application/json")
@AllArgsConstructor
public class TeacherController {

  private final TeacherService teacherService;
  private final TeacherMapper mapper;

  /*public TeacherController(TeacherService teacherService, TeacherMapper mapper) {
    this.teacherService = teacherService;
    this.mapper = mapper;
  }*/

  @PostMapping
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<TeacherResource> createTeacher(@RequestBody CreateTeacherResource resource) {
    Teacher teacherInput = mapper.toModel(resource);
    Teacher teacherSaved = teacherService.create(teacherInput);
    TeacherResource teacherResource = mapper.toResource(teacherSaved);
    return new ResponseEntity<>(teacherResource, HttpStatus.CREATED); // 201
  }
}
