package com.vivian.user_app.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginDTO {
    private @NotEmpty(
            message = "Email name is required"
    ) @NotNull(
            message = "Email name cannot be null"
    ) String email;
    private @NotEmpty(
            message = "Password is required"
    ) @NotNull(
            message = "Password cannot be null"
    ) String password;
}
