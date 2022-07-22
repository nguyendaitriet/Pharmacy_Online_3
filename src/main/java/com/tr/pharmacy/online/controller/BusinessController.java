package com.tr.pharmacy.online.controller;

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
@RequestMapping("/business")
public class BusinessController {

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

    @GetMapping
    public ModelAndView showBusinessPage() {
        ModelAndView modelAndView = new ModelAndView("/home-page/business");
        modelAndView.addObject("username", getPrincipalName());
        return modelAndView;
    }
}
