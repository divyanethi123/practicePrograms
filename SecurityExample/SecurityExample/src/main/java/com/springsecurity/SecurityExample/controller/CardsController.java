package com.springsecurity.SecurityExample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
    @GetMapping("/myCards")
    public String  cardDetails(){
        return "user  card details are blank bank";
    }
}
