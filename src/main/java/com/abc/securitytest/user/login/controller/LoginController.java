package com.abc.securitytest.user.login.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/api/v1/login")
    public void handleLogin() {

    }
}
