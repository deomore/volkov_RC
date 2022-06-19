package com.vlsu.volkov.utils.exception;

import com.vlsu.volkov.utils.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthHelper {
    private final JwtProvider jwtProvider;

    public String getUserEmail() {
        return jwtProvider.getEmailFromToken(SecurityContextHolder.getContext().getAuthentication().getDetails().toString());
    }
}
