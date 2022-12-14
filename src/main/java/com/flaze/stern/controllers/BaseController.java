package com.flaze.stern.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Welcome to STERN";
    }

}
