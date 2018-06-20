package com.college.adminportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.college.adminportal.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}