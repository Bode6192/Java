package com.springbot.blog.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Schema(
        description = "PostDtoV1 Model Information"
)
public class PostDtoV1 {

    @Schema(
            description = "Blog Post Id"
    )
    private long id;

    @Schema(
            description = "Blog Post Title"
    )
    @NotEmpty
    @NotNull
    @Size(min = 5, message = "Post Title should have at least five Characters")
    private String title;

    @Schema(
            description = "Blog Post Description"
    )
    @NotEmpty
    @NotNull
    @Size(min = 10, message = "Post Description should have at least ten Characters")
    private String description;

    @Schema(
            description = "Blog Post Content"
    )
    @NotEmpty
    @NotNull
    private String content;

    @Schema(
            description = "Blog Post Comments"
    )
    private Set<CommentDto> comments;

    @Schema(
            description = "Blog Post's Category Id "
    )
    @NotNull
    private Long categoryId;
}
