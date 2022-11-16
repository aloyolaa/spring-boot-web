package com.aloyolaa.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class VariableController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Send route parameters: (@PathVariable)");
        return "variables/index";
    }

    @GetMapping("/string/{text}")
    public String variables(@PathVariable String text, Model model) {
        model.addAttribute("title", "Receive route parameters: (@PathVariable)");
        model.addAttribute("result", "Text send is: " + text);
        return "variables/view";
    }

    @GetMapping("/string/{text}/{number}")
    public String variables(@PathVariable String text, @PathVariable Integer number, Model model) {
        model.addAttribute("title", "Receive route parameters: (@PathVariable)");
        model.addAttribute("result", "Text send is: " + text + " and number is: " + number);
        return "variables/view";
    }

}
