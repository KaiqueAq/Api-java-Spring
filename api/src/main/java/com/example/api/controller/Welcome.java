package com.example.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @GetMapping("/")
    public String mensagem() {
        return "Hello, world!";
    }

    @GetMapping("/dev")
    public String dev() {
        return "oi...................";
    }

    @GetMapping("/curso")
    public String curso() {
        return "oi, oi ,oi";
    }
}
