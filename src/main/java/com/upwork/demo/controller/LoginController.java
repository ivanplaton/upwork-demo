package com.upwork.demo.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class LoginController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome(Principal principal, Model model) {
        model.addAttribute("username", principal.getName());
        return "welcome";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
