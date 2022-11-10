package com.acme.learningcenter.learning.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CriterionResourceId {

    private Long id;

    private String name;

    private SkillResourceId skill;

}
