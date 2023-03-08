package com.mnkqn.userservice.domain.dto;

import javax.validation.constraints.*;

public class UserCreateDto {

    @NotNull(message="First name cannot be null")
    @Size(min=2, message= "First name must not be less than two characters")
    private String firstName;

    @NotNull(message="Last name cannot be null")
    @Size(min=2, message= "Last name must not be less than two characters")
    private String lastName;

    @NotNull(message="Password cannot be null")
    @Size(min=8, max=16, message="Password must be equal or grater than 8 characters and less than 16 characters")
    private String password;

    @NotNull(message="Email cannot be null")
    @Email
    private String email;
}
