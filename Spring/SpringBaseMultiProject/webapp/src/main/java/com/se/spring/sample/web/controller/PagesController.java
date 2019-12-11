package com.se.spring.sample.web.controller;


import com.se.spring.sample.web.config.SecurityConfiguration;
import com.se.spring.sample.web.exception.SdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller of webapp
 * Created by Daniil Sanin<sdi@simple-digit.ru> on 27.06.2017.
 */
@Controller
public class PagesController {

    private PersistentTokenRepository tokenRepository;

    @Autowired
    public void setPersistentTokenRepository(PersistentTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @RequestMapping(value = "/test")
    public String showTest(Model model) {
        return "test";
    }

    @RequestMapping(value = "/testerror")
    public String showError(Model model) {
        throw new SdException();
    }


    @RequestMapping(value = "/")
    public String showIndex(Model model) {
        return "index";
    }

    @RequestMapping(value = "/admin")
    public String showAdmin(Model model) {
        return "admin";
    }

    @RequestMapping(value = "/login")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/403")
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String accessDenied(Model model) {
        return "errors/403";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            tokenRepository.removeUserTokens(auth.getName());
            new SecurityContextLogoutHandler().logout(request, response, auth);
            new CookieClearingLogoutHandler(SecurityConfiguration.REMEMBER_ME_COOKIE).logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

}