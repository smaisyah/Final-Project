package com.mii.merodata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mii.merodata.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{
    
}
