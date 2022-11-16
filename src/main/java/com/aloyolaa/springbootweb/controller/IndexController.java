package com.aloyolaa.springbootweb.controller;

import com.aloyolaa.springbootweb.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${text.indexcontroller.index.title}")
    private String textIndex;
    @Value("${text.indexcontroller.profile.title}")
    private String textProfile;
    @Value("${text.indexcontroller.list.title}")
    private String textList;

    @GetMapping({"", "/", "/home", "/index"})
    public String index(Model model) {
        model.addAttribute("title", textIndex);
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        User user = new User();
        user.setFirstName("Alan");
        user.setLastName("Loyola");
        user.setEmail("aloyolaa@gmail.com");
        model.addAttribute("title", textProfile + user.getFirstName());
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("title", textList);
        model.addAttribute("users", Arrays.asList(
                new User("Alan", "Loyola", "aloyolaa@gmail.com"),
                new User("Gabriel", "Loyola", "gabriel@gmail.com"),
                new User("Jackeline", "Alvarez", "jackeline@gmail.com")
        ));
        return "list";
    }

    /*@ModelAttribute("users")
    public List<User> users() {
        return Arrays.asList(
                new User("Alan", "Loyola", "aloyolaa@gmail.com"),
                new User("Gabriel", "Loyola", "gabriel@gmail.com"),
                new User("Jackeline", "Alvarez", "jackeline@gmail.com")
        );
    }*/

}
