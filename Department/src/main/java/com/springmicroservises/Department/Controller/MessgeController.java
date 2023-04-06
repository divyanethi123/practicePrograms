package com.springmicroservises.Department.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessgeController {
    @Value("${spring.boot.message}")
    private String message;

    @GetMapping("message")
    public String message(){
        return  message;
    }

}
