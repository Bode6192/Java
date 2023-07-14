package com.springbot.blog.controller;

import com.springbot.blog.payload.CommentDto;
import com.springbot.blog.service.CommentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts/{postId}/comments")
@Tag(
        name = "CRUD REST APIs for Comment Resource"
)
public class CommentController {

    private final CommentService commentService;


    @PostMapping
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long postId,
                                    @Valid @RequestBody CommentDto commentDto){

        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<CommentDto> getCommentByPostId(@PathVariable(value = "postId") long postId) {

        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDto> getCommentByCommentId(@PathVariable(value = "postId") long postId,
                                                            @PathVariable(value = "commentId") long commentId){

        return commentService.getCommentByCommentId(postId, commentId);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<CommentDto> updateCommentByCommentId(@PathVariable(value = "postId") long postId,
                                                               @PathVariable(value = "commentId") long commentId,
                                                               @Valid @RequestBody CommentDto commentRequest){

        return commentService.updateCommentByCommentId(postId, commentId, commentRequest);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteCommentByCommentId(@PathVariable(value = "postId") long postId,
                                                           @PathVariable(value = "commentId") long commentId){

        return commentService.deleteCommentByCommentId(postId, commentId);
    }
}
