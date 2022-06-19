package com.vlsu.volkov.service.impl;

import com.vlsu.volkov.dto.AuthRequestDto;
import com.vlsu.volkov.dto.AuthResponseDto;
import com.vlsu.volkov.model.User;
import com.vlsu.volkov.service.AuthService;
import com.vlsu.volkov.service.UserService;
import com.vlsu.volkov.utils.exception.BusinessException;
import com.vlsu.volkov.utils.exception.ErrorCode;
import com.vlsu.volkov.utils.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final JwtProvider jwtProvider;
    private final UserService userService;
    private final PasswordEncoder encoder;

    @Override
    public AuthResponseDto createToken(AuthRequestDto requestDto) {
        User user = userService.findByLogin(requestDto.getLogin());;
        if(Objects.nonNull(user) && encoder.matches(requestDto.getPassword(), user.getPassword())) {
            return new AuthResponseDto().setToken(jwtProvider.generateToken(user)).setRoles(user.getRoles().stream().map(item -> item.getTitle().toString()).collect(Collectors.toList()));
        } else {
            throw new BusinessException().setCode(ErrorCode.WRONG_CREDENTIALS);
        }
    }
}