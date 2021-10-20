package com.acme.learningcenter.learning.api;

import com.acme.learningcenter.learning.domain.service.CommentService;
import com.acme.learningcenter.learning.domain.service.PostService;
import com.acme.learningcenter.learning.mapping.CommentMapper;
import com.acme.learningcenter.learning.resource.CommentResource;
import com.acme.learningcenter.learning.resource.CreateCommentResource;
import com.acme.learningcenter.learning.resource.UpdateCommentResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts/{postId}/comments")
public class CommentController {

    private final CommentService commentService;

    private final CommentMapper mapper;

    public CommentController(CommentService commentService, CommentMapper mapper) {
        this.commentService = commentService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<CommentResource> getAllCommentsByPostId(@PathVariable Long postId, Pageable pageable) {
        return mapper.modelListToPage(commentService.getAllByPostId(postId), pageable);
    }

    @PostMapping
    public CommentResource createComment(@PathVariable Long postId,
                                         @RequestBody CreateCommentResource request) {
        return mapper.toResource(commentService.create(postId, mapper.toModel(request)));
    }


    @PutMapping("{commentId}")
    public CommentResource updateComment(@PathVariable Long postId,
                                         @PathVariable Long commentId,
                                         @RequestBody UpdateCommentResource request) {
        return mapper.toResource(commentService.update(postId, commentId, mapper.toModel(request)));
    }

    @DeleteMapping("{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long postId,
                                           @PathVariable Long commentId) {
        return commentService.delete(postId, commentId);
    }
}
