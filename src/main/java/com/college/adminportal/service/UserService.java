package com.college.adminportal.service;

import com.college.adminportal.entity.User;

public interface UserService {

	void save(User user);

	User findByUsername(String username);

}
