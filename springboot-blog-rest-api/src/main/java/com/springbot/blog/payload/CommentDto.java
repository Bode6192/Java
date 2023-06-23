package com.springbot.blog.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

    private long id;

    @NotEmpty(message = "Email should not be null or empty")
    @Size(min = 3, message = "Name should have at least three characters")
    private String name;

    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;

    @NotEmpty(message = "Message body should not be null or empty")
    @Size(min = 10, message = "Name should have at least ten characters")
    private String messageBody;
}
