package com.vivian.user_app.service.impl;

import com.vivian.user_app.dto.APIResponse;
import com.vivian.user_app.dto.SignupDTO;
import com.vivian.user_app.entity.User;
import com.vivian.user_app.vo.UserVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserService {
    APIResponse<UserVO> updateUser(Long userId, SignupDTO dto);
    APIResponse<UserVO> viewUser(Long userId);
    APIResponse<UserVO> deleteUser(Long userId);
    APIResponse<UserVO> acceptUserDetails(SignupDTO dto, MultipartFile curriculumVitae) throws IOException;
}
