package com.springsecurity.SecurityExample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @GetMapping("/contacts")
    public String  details(){
        return "bank contact number 876567980";
    }
}
