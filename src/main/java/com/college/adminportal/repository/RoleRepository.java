package com.college.adminportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.adminportal.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
}
