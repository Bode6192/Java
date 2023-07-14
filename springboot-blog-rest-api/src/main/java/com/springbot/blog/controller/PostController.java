package com.springbot.blog.controller;

import com.springbot.blog.payload.response.PostResponse;
import com.springbot.blog.payload.PostDtoV1;
import com.springbot.blog.service.PostService;
import com.springbot.blog.utils.AppConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(
        name = "CRUD REST APIs for Post Resource"
)
@RequestMapping("/api/v1/posts")
public class PostController {


    @Autowired
    private PostService postService;


    @PreAuthorize("hasRole('ADMIN')")
    // Versioning through URL Paths - Most used by Top Companies
    @PostMapping
    @SecurityRequirement(
            name = "Bearer Authentication"
    )
    @Operation(
            summary = "Create Post REST API",
            description = "This API saves a Post to the Database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    public ResponseEntity<PostDtoV1> createPost(@Valid @RequestBody PostDtoV1 postDtoV1) {

        return new ResponseEntity<>(postService.createPost(postDtoV1), HttpStatus.CREATED);
    }


    @Operation(
            summary = "Get Posts REST API",
            description = "This API returns all Posts from the Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 OK"
    )
    // Versioning through URL Paths
    @GetMapping
    public PostResponse getAllPosts(@RequestParam(value = "pageNo",
                                            defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                    @RequestParam(value = "pageSize",
                                            defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
                                    @RequestParam(value = "sortBy",
                                            defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
                                    @RequestParam(value = "sortDir",
                                            defaultValue = AppConstants.DEFAULT_SORT_SIZE, required = false) String sortDir) {

        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }


    @Operation(
            summary = "Get Post REST API Version 1 By Id",
            description = "This API returns a Post By the given Id from the Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 OK"
    )
    // Versioning through Parameters
    @GetMapping(value = "/{id}", params = "version=1")
    public ResponseEntity<PostDtoV1> getPostByIdV1(@PathVariable(name = "id") long id) {

        return ResponseEntity.ok(postService.getPostById(id));
    }


    @SecurityRequirement(
            name = "Bearer Authentication"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(
            summary = "Update Post REST API",
            description = "This API makes changes a Created Post and saves it again to the Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 OK"
    )
    // Versioning through URL Paths
    @PutMapping("/{id}")
    public ResponseEntity<PostDtoV1> updatePost(@Valid @RequestBody PostDtoV1 postDtoV1, @PathVariable(name = "id") long id) {

        PostDtoV1 postDtoV11 = postService.updatePost(postDtoV1, id);
        return ResponseEntity.ok(postDtoV11);
    }


    @SecurityRequirement(
            name = "Bearer Authentication"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(
            summary = "Delete Post REST API",
            description = "This API deletes a Post from the Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 OK"
    )
    // Versioning through URL Paths
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable("id") Long id) {

        postService.deletePostById(id);
        return ResponseEntity.ok().body("Post with id " + id + " has been deleted");
    }


    @Operation(
            summary = "Get Post REST API by Category Id",
            description = "This API returns all Posts having a given Category Id from the Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 OK"
    )
    // Versioning through URL Paths
    @GetMapping("/category/{id}")
    public ResponseEntity<List<PostDtoV1>> getPostsByCategoryId(@PathVariable("id") Long categoryId){

       List<PostDtoV1> postDtoV1s = postService.getPostsByCategoryId(categoryId);

       return ResponseEntity.ok().body(postDtoV1s);
    }
}