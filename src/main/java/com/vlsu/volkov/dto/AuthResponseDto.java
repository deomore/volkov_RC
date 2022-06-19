package com.vlsu.volkov.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class AuthResponseDto {
    private String token;
    private List<String> roles;
}