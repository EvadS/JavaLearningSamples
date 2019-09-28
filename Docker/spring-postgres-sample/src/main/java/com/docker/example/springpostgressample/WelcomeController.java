package com.docker.example.springpostgressample;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message","message");
        model.addAttribute("tasks", "tasks");

        return "welcome"; //view
    }
}
