package com.acme.learningcenter.learning.domain.persistence;

import com.acme.learningcenter.learning.domain.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
  Teacher findByName(String name);
  Teacher findByDni(String dni);
}
