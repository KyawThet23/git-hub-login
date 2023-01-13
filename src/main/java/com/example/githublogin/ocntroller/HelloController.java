package com.example.githublogin.ocntroller;


import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class HelloController {

    private Logger logger=
            Logger.getLogger(HelloController.class.getName());

    @GetMapping("/")
    public String main(OAuth2AuthenticationToken token){
        logger.info(String.valueOf(token.getPrincipal()));
        return "hello.html";
    }
}
