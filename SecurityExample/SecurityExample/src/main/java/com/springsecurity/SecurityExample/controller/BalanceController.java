package com.springsecurity.SecurityExample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    @GetMapping("/myBalance")
    public String  checkBalance(){
        return "user balance is 700000";
    }
}
