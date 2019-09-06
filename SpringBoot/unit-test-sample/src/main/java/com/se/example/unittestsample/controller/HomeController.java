package com.se.example.unittestsample.controller;

import com.se.example.unittestsample.components.EnvUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "Hello World!\n";
    }

//request.getLocalPort()
    //request.getLocalAddr()

    @GetMapping("/current")
    public String register(HttpServletRequest request) {
        return request.getRequestURL().toString();
//value: http://localhost:8080/registration

    }

    @Autowired
    private EnvUtil envUtil;

    /**
     * env
     *
     * @return
     */
    @GetMapping(path = "/env")
    @ResponseBody
    public String env() throws UnknownHostException {
        Map<String, Object> map = new HashMap<>();
        map.put("port", envUtil.getPort());
        map.put("host", envUtil.getHostname());
        return map.toString();
    }
}