package com.vivian.user_app.service.impl;

import com.vivian.user_app.dto.APIResponse;
import com.vivian.user_app.dto.SignupDTO;
import com.vivian.user_app.entity.User;
import com.vivian.user_app.exception.UserExistsException;
import com.vivian.user_app.exception.UserNotFoundException;
import com.vivian.user_app.repository.UserRepository;
import com.vivian.user_app.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final FileUploadService fileUploadService;


    @Override
    public APIResponse<UserVO> updateUser(Long userId, SignupDTO dto) {
        return userRepository.findById(userId)
                .map(user -> {
                    User newUser = mapper.map(dto, User.class);
                    User savedUser = userRepository.save(newUser);
                    UserVO userVO = mapper.map(savedUser, UserVO.class);
                    return APIResponse.<UserVO>builder()
                            .data(userVO)
                            .status(200)
                            .message("User Updated Successfully")
                            .build();
                })
                .orElseThrow(()-> new UserNotFoundException("User not Found"));
    }

    @Override
    public APIResponse<UserVO> viewUser(Long userId) {
        return userRepository.findById(userId)
                .map(user -> {
                    UserVO userVO = mapper.map(user, UserVO.class);
                    return APIResponse.<UserVO>builder()
                            .data(userVO)
                            .status(200)
                            .message("User Found")
                            .build();
                })
                .orElseThrow(()-> new UserNotFoundException("User not Found"));
    }

    @Override
    public APIResponse<UserVO> deleteUser(Long userId) {
        return userRepository.findById(userId)
                .map(user -> {
                    userRepository.delete(user);
                    return APIResponse.<UserVO>builder()
                            .data(null)
                            .status(200)
                            .message("User deleted Successfully")
                            .build();
                })
                .orElseThrow(()-> new UserNotFoundException("User not Found"));
    }

    @Override
    @Transactional
    public APIResponse<UserVO> acceptUserDetails(SignupDTO dto, MultipartFile curriculumVitae) throws IOException {
        Optional<User> existingUser =  userRepository.findUserByEmail(dto.getEmail());
        if (existingUser.isPresent()){
            throw new UserExistsException("User exists");
        }
        User newUser = mapper.map(dto, User.class);
        newUser.setCurriculumVitae(fileUploadService.uploadFile(curriculumVitae));
        User savedUser = userRepository.save(newUser);
        UserVO userVO = mapper.map(savedUser, UserVO.class);
        return APIResponse.<UserVO>builder()
                .data(userVO)
                .status(200)
                .message("User Details Added Successfully")
                .build();
    }
}



