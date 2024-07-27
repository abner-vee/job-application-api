package com.vivian.user_app.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class SignupDTO {
    private String firstName;
    private String lastName;
    private @NotEmpty(message = "Email name is required")
    @NotNull(message = "Email name cannot be null")
    String email;
    private String dob;
    @NotNull(message = "Password cannot be null")
    String password;
}
