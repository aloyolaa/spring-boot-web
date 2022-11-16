package com.aloyolaa.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class ParamController {

    @GetMapping("/")
    public String index() {
        return "params/index";
    }

    @GetMapping("/string")
    public String param(@RequestParam(required = false) String text, Model model) {
        model.addAttribute("result", "Text sent is: " + text);
        return "params/view";
    }

    @GetMapping("/mix-params")
    public String param(@RequestParam String greeting, @RequestParam Integer number, Model model) {
        model.addAttribute("result", "Greeting sent is: '" + greeting + "' and number is: " + number);
        return "params/view";
    }

    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model) {
        String greeting = request.getParameter("greeting");
        Integer number = null;
        try {
            number = Integer.parseInt(request.getParameter("number"));
        } catch (NumberFormatException e) {
            number = 0;
        }
        model.addAttribute("result", "Greeting sent is: '" + greeting + "' and number is: " + number);
        return "params/view";
    }

}
