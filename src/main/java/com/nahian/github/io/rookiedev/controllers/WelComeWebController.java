package com.nahian.github.io.rookiedev.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelComeWebController {
    @GetMapping("/welcome")
    public String index() {
        return "Welcome";
    }
}
