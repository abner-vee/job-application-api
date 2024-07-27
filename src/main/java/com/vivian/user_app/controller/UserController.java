package com.vivian.user_app.controller;

import com.vivian.user_app.dto.APIResponse;
import com.vivian.user_app.dto.SignupDTO;
import com.vivian.user_app.service.impl.UserService;
import com.vivian.user_app.vo.UserVO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping({"/api/v1/users"})
public class UserController {

        @Autowired
        private UserService userService;

        @PutMapping("/{userId}")
        public ResponseEntity<APIResponse<UserVO>> updateUser(@PathVariable Long userId, @RequestBody SignupDTO dto) {
            APIResponse<UserVO> response = userService.updateUser(userId, dto);
            return ResponseEntity.status(response.getStatus()).body(response);
        }

        @GetMapping("/{userId}")
        public ResponseEntity<APIResponse<UserVO>> viewUser(@PathVariable Long userId) {
            APIResponse<UserVO> response = userService.viewUser(userId);
            return ResponseEntity.status(response.getStatus()).body(response);
        }

        @DeleteMapping("/{userId}")
        public ResponseEntity<APIResponse<UserVO>> deleteUser(@PathVariable Long userId) {
            APIResponse<UserVO> response = userService.deleteUser(userId);
            return ResponseEntity.status(response.getStatus()).body(response);
        }

//    private String firstName;
//    private String lastName;
//    private @NotEmpty(message = "Email name is required")
//    @NotNull(message = "Email name cannot be null")
//    String email;
//    private String dob;
//    @NotNull(message = "Password cannot be null")
//    String password;

        @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        public ResponseEntity<APIResponse<UserVO>> acceptUserDetails(
                @RequestParam String firstName,
                @RequestParam String lastName,
                @RequestParam String email,
                @RequestParam String dob,
                @RequestParam String password,
                @RequestPart MultipartFile curriculumVitae
        ) throws IOException {
            SignupDTO signupDTO = SignupDTO.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .email(email)
                    .dob(dob)
                    .password(password)
                    .build();
            APIResponse<UserVO> response = userService.acceptUserDetails(signupDTO, curriculumVitae);
            return ResponseEntity.status(response.getStatus()).body(response);
        }
    }


