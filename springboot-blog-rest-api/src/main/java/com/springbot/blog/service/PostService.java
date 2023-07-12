package com.springbot.blog.service;

import com.springbot.blog.entity.Category;
import com.springbot.blog.entity.Post;
import com.springbot.blog.payload.response.PostResponse;
import com.springbot.blog.exception.ResourceNotFoundException;
import com.springbot.blog.payload.PostDto;
import com.springbot.blog.repository.CategoryRepository;
import com.springbot.blog.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private CategoryRepository categoryRepository;


    public PostDto createPost(PostDto postDto){

        Category category = categoryRepository.findById(postDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Id", postDto.getCategoryId()));

        Post post = modelMapper.map(postDto, Post.class);
        post.setCategory(category);
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

        Category category = categoryRepository.findById(postDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Id", postDto.getCategoryId()));

        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        post.setTitle(postDto.getTitle());
        post.setCategory(category);

        Post updatePost = postRepository.save(post);

        return modelMapper.map(updatePost, PostDto.class);
    }


    public void deletePostById(Long id) {

        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }


    public List<PostDto> getPostsByCategoryId(Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));

        List<Post> posts = postRepository.findByCategoryId(categoryId);

        return posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }
}
