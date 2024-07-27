package com.vivian.user_app.entity;

import com.vivian.user_app.commons.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String dob;
    @Column(
            unique = true
    )
    private String email;
    private String curriculumVitae;

}