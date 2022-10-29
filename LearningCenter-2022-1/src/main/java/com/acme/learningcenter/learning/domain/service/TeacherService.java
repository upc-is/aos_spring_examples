package com.acme.learningcenter.learning.domain.service;

import com.acme.learningcenter.learning.domain.model.entity.Student;
import com.acme.learningcenter.learning.domain.model.entity.Teacher;

import java.util.List;

public interface TeacherService {

  List<Teacher> getAll();

  Teacher create(Teacher teacher);
}
