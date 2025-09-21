package com.douglas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("home")
public class LoginController {
    


    @GetMapping("/login")
    public ModelAndView carregaTelaLogin() {
        return new ModelAndView("loginView");
    }

    
    
}
