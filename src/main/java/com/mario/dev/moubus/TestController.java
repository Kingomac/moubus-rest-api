package com.mario.dev.moubus;

import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TestController {

    @GetMapping("/test")
    public String getAuthenticatedUsername(Principal principal) {
        return principal.getName();
    }

}
