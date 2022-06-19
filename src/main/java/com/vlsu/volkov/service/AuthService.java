package com.vlsu.volkov.service;


import com.vlsu.volkov.dto.AuthRequestDto;
import com.vlsu.volkov.dto.AuthResponseDto;

public interface AuthService {
    AuthResponseDto createToken(AuthRequestDto requestDto);
}


