package com.aloyolaa.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "forward:/app/index"; //forward para rutas de la aplicación y redirect para rutas externas
    }

}
