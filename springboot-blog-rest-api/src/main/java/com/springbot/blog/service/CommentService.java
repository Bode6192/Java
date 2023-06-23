package com.springbot.blog.service;

import com.springbot.blog.entity.Comment;
import com.springbot.blog.entity.Post;
import com.springbot.blog.exception.BlogAPIException;
import com.springbot.blog.exception.ResourceNotFoundException;
import com.springbot.blog.payload.CommentDto;
import com.springbot.blog.repository.CommentRepository;
import com.springbot.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    private final ModelMapper modelMapper = new ModelMapper();


    public CommentDto createComment(Long postId, CommentDto commentDto){

        Post post = postRepository.findById(postId).orElseThrow(() ->
                new ResourceNotFoundException("Post", "Id", postId));

        Comment comment = modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);

        commentRepository.save(comment);

        return modelMapper.map(comment, CommentDto.class);
    }


    public List<CommentDto> getCommentsByPostId(long postId){

        List<Comment> comments = commentRepository.findCommentsByPostId(postId);

        return comments.stream().map(comment -> modelMapper.map(comment, CommentDto.class)).toList();
    }


    public ResponseEntity<CommentDto> getCommentByCommentId(long postId, long commentId) {

        Post post1 = postRepository.findById(postId).orElseThrow(() ->
                new ResourceNotFoundException("Post", "Id", postId));

        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
                new ResourceNotFoundException("Comment", "id", commentId));
        Post post2 = comment.getPost();

        if (!post2.getId().equals(post1.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to Post");
        }

        return ResponseEntity.ok(modelMapper.map(comment, CommentDto.class));
    }


    public ResponseEntity<CommentDto> updateCommentByCommentId(long postId, long commentId, CommentDto commentRequest) {

        Post post = postRepository.findById(postId).orElseThrow(() ->
                new ResourceNotFoundException("Post", "Id", postId));

        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
                new ResourceNotFoundException("Comment", "id", commentId));

        if (!comment.getPost().getId().equals(post.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to Post");
        }

        comment.setName(commentRequest.getName());
        comment.setEmail(commentRequest.getEmail());
        comment.setMessageBody(commentRequest.getMessageBody());

        Comment updatedComment = commentRepository.save(comment);

        return ResponseEntity.ok(modelMapper.map(updatedComment, CommentDto.class));
    }
}