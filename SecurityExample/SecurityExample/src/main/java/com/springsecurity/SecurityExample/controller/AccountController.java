package com.springsecurity.SecurityExample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/myAccount")
    public String home(){
        return "user is in Account Controller";
    }
}
