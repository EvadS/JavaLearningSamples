package com.se.sample.demoflywayenv.controller;

import com.se.sample.demoflywayenv.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by rajeevkumarsingh on 02/07/17.
 */
@Controller
public class HomeController {

    private static final String appName = "ThymeleafTour";

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/")
    public String home(Model model,
                       @RequestParam(value = "name", required = false,
                               defaultValue = "Guest") String name) {

        long  messageCount = messageRepository.count();

        model.addAttribute("name", name);
        model.addAttribute("title", appName);
        model.addAttribute("messageCount", messageCount);


        return "home";

    }
}