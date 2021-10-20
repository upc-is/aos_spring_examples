package com.acme.learningcenter.learning.mapping;

import com.acme.learningcenter.learning.domain.model.entity.Comment;
import com.acme.learningcenter.learning.resource.*;
import com.acme.learningcenter.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class CommentMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public CommentResource toResource(Comment model) {
        return mapper.map(model, CommentResource.class);
    }

    public Page<CommentResource> modelListToPage(List<Comment> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, CommentResource.class), pageable, modelList.size());
    }

    public Comment toModel(CreateCommentResource resource) {
        return mapper.map(resource, Comment.class);
    }

    public Comment toModel(UpdateCommentResource resource) {
        return mapper.map(resource, Comment.class);
    }
}
