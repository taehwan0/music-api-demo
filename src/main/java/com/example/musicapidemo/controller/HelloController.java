package com.example.musicapidemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class HelloController {

    @GetMapping({"", "/hello"})
    public ResponseEntity<String> responseHello() {
        return ResponseEntity
            .status(200)
            .body("Hello, World");
    }
}
