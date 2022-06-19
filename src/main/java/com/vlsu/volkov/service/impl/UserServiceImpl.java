package com.vlsu.volkov.service.impl;

import com.vlsu.volkov.config.ApplicationProperties;
import com.vlsu.volkov.model.User;
import com.vlsu.volkov.repository.UserRepository;
import com.vlsu.volkov.service.RoleService;
import com.vlsu.volkov.service.UserService;
import com.vlsu.volkov.utils.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final ApplicationProperties applicationProperties;
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final RoleService roleService;
    private final JwtProvider jwtProvider;

    @Override
    public User findByLogin(String login) {
        return repository.findByEmail(login);
    }







    @FunctionalInterface
    private interface ChangePersonalInfoFunction {
        void change(User user, String newInfo);
    }
}
