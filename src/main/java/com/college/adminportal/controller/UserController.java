package com.college.adminportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.college.adminportal.entity.User;
import com.college.adminportal.service.SecurityService;
import com.college.adminportal.service.UserService;
import com.college.adminportal.validator.UserValidator;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
    	ModelAndView model = new ModelAndView();
    	model.setViewName("registration");
        model.addObject("userForm", new User());
        return model;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
    	ModelAndView model = new ModelAndView();
    	userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
        	model.setViewName("registration");
            return model;
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        model.setViewName("welcome");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(String error, String logout) {
    	ModelAndView model = new ModelAndView();
        if (error != null)
            model.addObject("error", "Your username and password is invalid.");

        if (logout != null)
            model.addObject("message", "You have been logged out successfully.");
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public ModelAndView welcome() {
    	ModelAndView model = new ModelAndView();
    	model.setViewName("welcome");
    	return model;
    }
}