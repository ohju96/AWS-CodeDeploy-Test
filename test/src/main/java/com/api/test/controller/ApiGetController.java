package com.api.test.controller;

import com.api.test.service.NameRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiGetController {

    private final NameRequest nameRequest;

    @GetMapping ("/name")
    public String getName() throws URISyntaxException, IOException {
        log.info("### .getName start");
        return nameRequest.getName();
    }
}
