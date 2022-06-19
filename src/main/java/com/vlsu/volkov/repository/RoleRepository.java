package com.vlsu.volkov.repository;

import com.vlsu.volkov.model.Role;
import com.vlsu.volkov.model.RoleTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByTitle(RoleTitle title);
}
