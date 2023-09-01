package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Role;
import java.util.List;


public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByRname(String rname);
}
