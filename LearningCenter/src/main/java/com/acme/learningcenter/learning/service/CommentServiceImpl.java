package com.acme.learningcenter.learning.service;

import com.acme.learningcenter.learning.domain.model.entity.Comment;
import com.acme.learningcenter.learning.domain.persistence.CommentRepository;
import com.acme.learningcenter.learning.domain.persistence.PostRepository;
import com.acme.learningcenter.learning.domain.service.CommentService;
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
public class CommentServiceImpl implements CommentService {

    private static final String ENTITY = "Comment";

    private final CommentRepository commentRepository;

    private final PostRepository postRepository;

    private final Validator validator;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, Validator validator) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.validator = validator;
    }

    @Override
    public List<Comment> getAllByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    @Override
    public Page<Comment> getAllByPostId(Long postId, Pageable pageable) {
        return commentRepository.findByPostId(postId, pageable);
    }

    @Override
    public Comment create(Long postId, Comment request) {
        Set<ConstraintViolation<Comment>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return postRepository.findById(postId).map(post -> {
            request.setPost(post);
            return commentRepository.save(request);
        }).orElseThrow(() -> new ResourceNotFoundException("Post", postId ));
    }

    @Override
    public Comment update(Long postId, Long commentId, Comment request) {

        Set<ConstraintViolation<Comment>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        if(!postRepository.existsById(postId))
            throw new ResourceNotFoundException("Post", postId);

        return commentRepository.findById(commentId).map(comment ->
                commentRepository.save(comment.withText(request.getText())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));

    }

    @Override
    public ResponseEntity<?> delete(Long postId, Long commentId) {

        return commentRepository.findByIdAndPostId(commentId, postId).map(comment -> {
            commentRepository.delete(comment);
            return ResponseEntity.ok().build();})
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));

    }
}
