package com.org.HMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Veena {
    @GetMapping("/")
    public String hello(){
        return "hello world";
    }
}
