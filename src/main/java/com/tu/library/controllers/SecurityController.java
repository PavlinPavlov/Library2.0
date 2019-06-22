package com.tu.library.controllers;

import com.tu.library.entity.User;
import com.tu.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password) {
        userRepo.save(new User(username, bCryptPasswordEncoder.encode(password)));
        return "registration";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

}
