package com.springbot.blog.service;

import com.springbot.blog.entity.Category;
import com.springbot.blog.entity.Post;
import com.springbot.blog.payload.response.PostResponse;
import com.springbot.blog.exception.ResourceNotFoundException;
import com.springbot.blog.payload.PostDtoV1;
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


    public PostDtoV1 createPost(PostDtoV1 postDtoV1){

        Category category = categoryRepository.findById(postDtoV1.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Id", postDtoV1.getCategoryId()));

        Post post = modelMapper.map(postDtoV1, Post.class);
        post.setCategory(category);
        Post newPost = postRepository.save(post);

        return modelMapper.map(newPost, PostDtoV1.class);
    }


    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> posts = postRepository.findAll(pageable);

        return modelMapper.map(posts, PostResponse.class);
    }


    public PostDtoV1 getPostById(long id) {

        Post post = (postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id)));
        return modelMapper.map(post, PostDtoV1.class);
    }


    public PostDtoV1 updatePost(PostDtoV1 postDtoV1, long id) {

        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        Category category = categoryRepository.findById(postDtoV1.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Id", postDtoV1.getCategoryId()));

        post.setContent(postDtoV1.getContent());
        post.setDescription(postDtoV1.getDescription());
        post.setTitle(postDtoV1.getTitle());
        post.setCategory(category);

        Post updatePost = postRepository.save(post);

        return modelMapper.map(updatePost, PostDtoV1.class);
    }


    public void deletePostById(Long id) {

        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }


    public List<PostDtoV1> getPostsByCategoryId(Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));

        List<Post> posts = postRepository.findByCategoryId(categoryId);

        return posts.stream().map(post -> modelMapper.map(post, PostDtoV1.class)).collect(Collectors.toList());
    }
}
