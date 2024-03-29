package com.acme.learningcenter.learning.resource;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateTeacherResource {

  @NotNull
  @NotBlank
  @Size(max = 60)
  private String name;

  @Min(18)
  private int age;

  @Size(max = 100)
  private String carrera;

  @NotBlank
  @Size(max = 8, min = 8)
  private String dni;
}
