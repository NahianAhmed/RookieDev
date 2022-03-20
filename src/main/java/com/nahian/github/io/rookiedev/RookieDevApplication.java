package com.nahian.github.io.rookiedev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RookieDevApplication {

    public static void main(String[] args) {
        SpringApplication.run(RookieDevApplication.class, args);
    }

}
