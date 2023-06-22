package com.springbot.blog.service;

import com.springbot.blog.entity.Post;
import com.springbot.blog.payload.PostResponse;
import com.springbot.blog.exception.ResourceNotFoundException;
import com.springbot.blog.payload.PostDto;
import com.springbot.blog.repository.PostRepository;
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

    public PostDto createPost(PostDto postDto){

        Post post = mapToEntity(postDto);
        Post newPost = postRepository.save(post);

       PostDto postDto1 = mapToDto(post);
       return postDto1;
    }

    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Post> posts = postRepository.findAll(pageable);

        List<Post> listOfPosts = posts.getContent();

        List<PostDto> content = listOfPosts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(content);
        postResponse.setPageNo(posts.getPageable().getPageNumber());
        postResponse.setPageSize(posts.getPageable().getPageSize());
        postResponse.setLast(posts.isLast());
        postResponse.setTotalElements(posts.getTotalElements());
        postResponse.setTotalPages(posts.getTotalPages());

        return postResponse;
    }

    public PostDto getPostById(long id) {

        Post post = (postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id)));
        return mapToDto(post);
    }

    public PostDto updatePost(PostDto postDto, long id) {

        System.out.println(postDto);

        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        post.setTitle(postDto.getTitle());

        Post updatePost = postRepository.save(post);
        return mapToDto(updatePost);
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

    public void deletePostById(Long id) {

        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }
}
