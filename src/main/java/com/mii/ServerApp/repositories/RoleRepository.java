package com.mii.ServerApp.repositories;

import com.mii.ServerApp.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// import org.springframework.stereotype.Repository;

@EnableJpaRepositories("com.acme.repositories")
// @Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    // Role findByRoleName(String roleName);
}
