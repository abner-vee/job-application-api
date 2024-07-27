package com.vivian.user_app.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private String firstName;
    private String lastName;
    private String dob;
    private String email;
    private String curriculumVitae;
}
