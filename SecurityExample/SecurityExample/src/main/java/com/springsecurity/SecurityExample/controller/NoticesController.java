package com.springsecurity.SecurityExample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {
    @GetMapping("/notices")
    public String  notifications(){
        return " for user there is new notification ";
    }
}
