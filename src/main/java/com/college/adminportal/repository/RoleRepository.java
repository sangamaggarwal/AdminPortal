package com.college.adminportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.college.adminportal.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
