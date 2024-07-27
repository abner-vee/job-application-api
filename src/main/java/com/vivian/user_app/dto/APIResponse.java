package com.vivian.user_app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class APIResponse<D> {
    private Integer status;
    private String message;
    private D data;
}
