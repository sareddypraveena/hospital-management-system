package com.org;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class contr {
    @GetMapping("/")
    public String heloo(){
        return "Hello World";
    }
}
