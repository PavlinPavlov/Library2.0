package com.tu.library.controllers;

import com.tu.library.entity.Book;
import com.tu.library.entity.TakenDetail;
import com.tu.library.entity.User;
import com.tu.library.repositories.BookRepository;
import com.tu.library.repositories.TakenDetailsRepository;
import com.tu.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class MainController {

    private final UserRepository userRepo;

    private final BookRepository bookRepo;

    private final TakenDetailsRepository detailsRepo;

    @Autowired
    public MainController(UserRepository userRepo, BookRepository bookRepo, TakenDetailsRepository detailsRepo) {
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
        this.detailsRepo = detailsRepo;
    }

    @GetMapping("/")
    public String home(Model model, Principal principal) {
        User user = userRepo.findByName(principal.getName());

        model.addAttribute("allBooks", bookRepo.findBooksByStatus(false));
        model.addAttribute("details", detailsRepo.findAllByUser(user));

        return "home";
    }

}
