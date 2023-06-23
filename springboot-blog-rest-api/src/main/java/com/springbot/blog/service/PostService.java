package com.springbot.blog.service;

import com.springbot.blog.entity.Post;
import com.springbot.blog.payload.response.PostResponse;
import com.springbot.blog.exception.ResourceNotFoundException;
import com.springbot.blog.payload.PostDto;
import com.springbot.blog.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    private final ModelMapper modelMapper = new ModelMapper();


    public PostDto createPost(PostDto postDto){

        Post post = modelMapper.map(postDto, Post.class);
        Post newPost = postRepository.save(post);

        return modelMapper.map(newPost, PostDto.class);
    }


    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> posts = postRepository.findAll(pageable);

        return modelMapper.map(posts, PostResponse.class);
    }


    public PostDto getPostById(long id) {

        Post post = (postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id)));
        return modelMapper.map(post, PostDto.class);
    }


    public PostDto updatePost(PostDto postDto, long id) {

        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        post.setTitle(postDto.getTitle());

        Post updatePost = postRepository.save(post);

        return modelMapper.map(updatePost, PostDto.class);
    }


    public void deletePostById(Long id) {

        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }
}
