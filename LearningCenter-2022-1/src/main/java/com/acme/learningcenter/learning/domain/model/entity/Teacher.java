package com.acme.learningcenter.learning.domain.model.entity;

import com.acme.learningcenter.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teachers")
public class Teacher extends AuditModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotBlank
  @Size(max = 60)
  @Column(unique = true)
  private String name;

  @Column
  private int age;

  @Size(max = 100)
  private String carrera;

  @NotBlank
  @Size(max = 8)
  private String dni;
}
