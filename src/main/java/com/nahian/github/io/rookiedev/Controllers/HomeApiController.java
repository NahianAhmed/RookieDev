package com.nahian.github.io.rookiedev.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeApiController {

    @GetMapping("/")
    public String index() {
        return "hello";
    }
}
