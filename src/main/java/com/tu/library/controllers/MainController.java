package com.tu.library.controllers;

import com.tu.library.entity.User;
import com.tu.library.repositories.BookRepository;
import com.tu.library.repositories.TakenDetailsRepository;
import com.tu.library.repositories.UserRepository;
import com.tu.library.services.BookService;
import com.tu.library.services.TakenDetailsService;
import com.tu.library.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    private final UserDetailsServiceImpl userDetailsService;
    private final BookService bookService;
    private final TakenDetailsService detailsService;

    public MainController(UserDetailsServiceImpl userDetailsService, BookService bookService, TakenDetailsService detailsService) {
        this.userDetailsService = userDetailsService;
        this.bookService = bookService;
        this.detailsService = detailsService;
    }


    @GetMapping("/")
    public String home(Model model) {
        Authentication auth  = SecurityContextHolder.getContext().getAuthentication();
        User user = userDetailsService.findByName(auth.getName());

        model.addAttribute("allBooks", bookService.findBooksByStatus(false));
        model.addAttribute("details", detailsService.findAllByUser(user));

        return "home";
    }
}
