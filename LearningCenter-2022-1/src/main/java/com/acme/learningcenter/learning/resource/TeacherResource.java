package com.acme.learningcenter.learning.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class TeacherResource {
  private Long id;
  private String name;
  private int age;
  private String carrera;
  private String dni;
}
