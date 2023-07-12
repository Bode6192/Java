package com.springbot.blog.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PostDto {

    private long id;

    @NotEmpty
    @NotNull
    @Size(min = 5, message = "Post Title should have at least five Characters")
    private String title;

    @NotEmpty
    @NotNull
    @Size(min = 10, message = "Post Description should have at least ten Characters")
    private String description;

    @NotEmpty
    @NotNull
    private String content;

    private Set<CommentDto> comments;

    @NotNull
    private Long categoryId;
}
