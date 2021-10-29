package com.acme.learningcenter.learning.service;

import com.acme.learningcenter.learning.domain.model.entity.Post;
import com.acme.learningcenter.learning.domain.persistence.PostRepository;
import com.acme.learningcenter.learning.domain.service.PostService;
import com.acme.learningcenter.shared.exception.ResourceNotFoundException;
import com.acme.learningcenter.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {

    private static final String ENTITY = "Post";

    private final PostRepository postRepository;

    private final Validator validator;

    public PostServiceImpl(PostRepository postRepository, Validator validator) {
        this.postRepository = postRepository;
        this.validator = validator;
    }


    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Page<Post> getAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Post getById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, postId));
    }

    @Override
    public Post create(Post request) {
        Set<ConstraintViolation<Post>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return postRepository.save(request);
    }

    @Override
    public Post update(Long postId, Post request) {

        Set<ConstraintViolation<Post>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return postRepository.findById(postId).map(post ->
                postRepository.save(
                    post.withTitle(request.getTitle())
                        .withDescription(request.getDescription())
                        .withContent(request.getContent()))
            ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, postId));
    }

    @Override
    public ResponseEntity<?> delete(Long postId) {
        return postRepository.findById(postId).map(post -> {
                postRepository.delete(post);
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, postId));
    }
}
