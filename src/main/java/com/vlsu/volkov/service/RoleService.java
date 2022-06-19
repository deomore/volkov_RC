package com.vlsu.volkov.service;

import com.vlsu.volkov.model.Role;
import com.vlsu.volkov.model.RoleTitle;

public interface RoleService {
    Role findByTitle(RoleTitle title);
}
