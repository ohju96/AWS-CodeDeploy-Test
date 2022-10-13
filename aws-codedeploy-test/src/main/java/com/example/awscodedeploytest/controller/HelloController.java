package com.example.awscodedeploytest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api")
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String helloPage() {
        return "Hello!";
    }
}