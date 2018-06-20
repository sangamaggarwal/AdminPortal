package com.college.adminportal.service;

public interface SecurityService {

	String findLoggedInUsername();

	void autologin(String username, String password);

}
