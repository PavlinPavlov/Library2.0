package com.tu.library.controllers;

import com.tu.library.entity.User;
import com.tu.library.repositories.UserRepository;
import com.tu.library.services.UserDetailsServiceImpl;
import com.tu.library.utils.RegistrationChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/security")
public class SecurityController {

    private final UserDetailsServiceImpl userDetailsService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public SecurityController(UserDetailsServiceImpl userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public ModelAndView register(@RequestParam("username") String username, @RequestParam("password") String password) {

        ModelAndView modelAndView = new ModelAndView("registration");

        if (!RegistrationChecker.validate(username, password)) {
            modelAndView.addObject("status", "invalid");
        } else if (userDetailsService.findByName(username) == null) {
            userDetailsService.save(new User(username, bCryptPasswordEncoder.encode(password)));
            modelAndView.addObject("status", "success");
        } else {
            modelAndView.addObject("status", "takenUsername");
        }

        return modelAndView;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

}
