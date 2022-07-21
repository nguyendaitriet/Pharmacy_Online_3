package com.tr.pharmacy.online.controller;

import com.tr.pharmacy.online.model.dto.UserDTO;
import com.tr.pharmacy.online.model.user.User;
import com.tr.pharmacy.online.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    private String getPrincipalName() {
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            Optional<User> currentUser = userService.findByUsername(username);
            username = currentUser.get().getFullName();
        } else {
            username = principal.toString();
        }

        return username;
    }

    private UserDTO getPrincipal() {
        UserDTO userDTO;
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        username = ((UserDetails) principal).getUsername();
        Optional<User> currentUser = userService.findByUsername(username);
        userDTO = currentUser.get().toUserDTO();
        return userDTO;
    }


    @GetMapping
    public ModelAndView showUserList() {
        ModelAndView modelAndView = new ModelAndView("/user-management/list");
        modelAndView.addObject("username", getPrincipalName());
        return modelAndView;
    }

    @GetMapping("/detail")
    public ModelAndView showUserDetail() {
        ModelAndView modelAndView = new ModelAndView("/user-management/detail");
        modelAndView.addObject("username", getPrincipalName());
        modelAndView.addObject("user", getPrincipal());
        return modelAndView;
    }

}
