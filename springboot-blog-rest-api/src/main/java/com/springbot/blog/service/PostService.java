package com.springbot.blog.service;

import com.springbot.blog.entity.Post;
import com.springbot.blog.payload.PostDto;
import com.springbot.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostDto createPost(PostDto postDto){

        Post post = mapToEntity(postDto);
        Post newPost = postRepository.save(post);

       PostDto postDto1 = mapToDto(post);
       return postDto1;
    }

    public List<PostDto> getAllPosts() {

        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
    }

    public Post getPostById() {

    }

    private PostDto mapToDto(Post post){

        PostDto newDto = new PostDto();
        newDto.setId(post.getId());
        newDto.setContent(post.getContent());
        newDto.setTitle(post.getTitle());
        newDto.setDescription(post.getDescription());

        return newDto;
    }

    private Post mapToEntity(PostDto postDto){

        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;
    }
}
