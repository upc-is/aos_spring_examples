package com.acme.learningcenter.learning.mapping;

import com.acme.learningcenter.learning.domain.model.entity.Post;
import com.acme.learningcenter.learning.resource.CreatePostResource;
import com.acme.learningcenter.learning.resource.PostResource;
import com.acme.learningcenter.learning.resource.UpdatePostResource;
import com.acme.learningcenter.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class PostMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public PostResource toResource(Post model) {
        return mapper.map(model, PostResource.class);
    }

    public Page<PostResource> modelListToPage(List<Post> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, PostResource.class), pageable, modelList.size());
    }

    public Post toModel(CreatePostResource resource) {
        return mapper.map(resource, Post.class);
    }

    public Post toModel(UpdatePostResource resource) {
        return mapper.map(resource, Post.class);
    }
}
