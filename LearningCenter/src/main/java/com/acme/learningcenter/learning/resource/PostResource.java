package com.acme.learningcenter.learning.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResource {
    private Long id;
    private String title;
    private String description;
    private String content;
}
