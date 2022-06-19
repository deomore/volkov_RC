package com.vlsu.volkov.service;


import com.vlsu.volkov.model.User;

public interface UserService {
    User findByLogin(String login);
}

