package com.vlsu.volkov.Controller;

import com.vlsu.volkov.dto.AuthRequestDto;
import com.vlsu.volkov.dto.AuthResponseDto;
import com.vlsu.volkov.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping
    @PreAuthorize("permitAll()")
    public AuthResponseDto authenticate(@RequestBody AuthRequestDto authRequestDto) {
        return authService.createToken(authRequestDto);
    }
}