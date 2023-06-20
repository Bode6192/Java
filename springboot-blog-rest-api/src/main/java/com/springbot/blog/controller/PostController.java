package com.springbot.blog.controller;

import com.springbot.blog.payload.PostDto;
import com.springbot.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){

        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<PostDto> getAllPosts(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
                                     @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize){

        return postService.getAllPosts(pageNo, pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id) {

        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable(name = "id") long id) {

        PostDto postDto1 = postService.updatePost(postDto, id);
        return ResponseEntity.ok(postDto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable("id") Long id) {

        postService.deletePostById(id);
        return ResponseEntity.ok().body("Post with id " + id + " has been deleted");
    }
}
