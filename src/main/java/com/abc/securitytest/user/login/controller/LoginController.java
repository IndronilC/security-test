package com.abc.securitytest.user.login.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/api/v1/login")
    public void handleLogin() {

    }
}
