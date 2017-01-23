package com.keratonjava.random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@SpringBootApplication
public class RandomApplication  {

    @RequestMapping("/random")
    public String get() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(RandomApplication.class, args);
    }

}