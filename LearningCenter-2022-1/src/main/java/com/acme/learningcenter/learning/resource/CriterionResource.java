package com.acme.learningcenter.learning.resource;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CriterionResource {

    private Long id;

    private String name;

    private SkillResource skill;

}
