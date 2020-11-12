package com.se.sample.basemvcservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Home redirection to swagger api documentation
 */

@ApiIgnore
@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String index() {
        return "redirect:swagger-ui.html";
    }
}
