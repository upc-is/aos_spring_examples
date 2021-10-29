package com.acme.learningcenter.learning.api;

import com.acme.learningcenter.learning.domain.service.PostService;
import com.acme.learningcenter.learning.mapping.PostMapper;
import com.acme.learningcenter.learning.resource.CreatePostResource;
import com.acme.learningcenter.learning.resource.PostResource;
import com.acme.learningcenter.learning.resource.UpdatePostResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/posts")
public class PostsController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostMapper mapper;

    @GetMapping
    public Page<PostResource> getAllPosts(Pageable pageable) {
        return mapper.modelListToPage(postService.getAll(), pageable);
    }

    @GetMapping("{postId}")
    public PostResource getPostById(@PathVariable("postId") Long postId) {
        return mapper.toResource(postService.getById(postId));
    }

    @PostMapping
    public PostResource createPost(@RequestBody CreatePostResource request) {

        return mapper.toResource(postService.create(mapper.toModel(request)));
    }

    @PutMapping("{postId}")
    public PostResource updatePost(@PathVariable Long postId, @RequestBody UpdatePostResource request) {
        return mapper.toResource(postService.update(postId, mapper.toModel(request)));
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        return postService.delete(postId);
    }



}
