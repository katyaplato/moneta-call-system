package com.example.moneta_call_system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
    @GetMapping
    public ModelAndView index (){
        return new ModelAndView("index.html");
    }
}
