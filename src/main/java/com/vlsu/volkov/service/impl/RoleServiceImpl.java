package com.vlsu.volkov.service.impl;

import com.vlsu.volkov.model.Role;
import com.vlsu.volkov.model.RoleTitle;
import com.vlsu.volkov.repository.RoleRepository;
import com.vlsu.volkov.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    public Role findByTitle(RoleTitle title) {
        return repository.findByTitle(title);
    }
}
