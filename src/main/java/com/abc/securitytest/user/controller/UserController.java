package com.abc.securitytest.user.controller;

import com.abc.securitytest.user.controller.requests.data.TestUsers;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/api/v1/users")
    public List<TestUsers> getUsers() {
        List<TestUsers> testUsers = new ArrayList<>();
        TestUsers tesUserObj = new TestUsers();
        tesUserObj.setUserName("Indronil");
        tesUserObj.setAge("52");
        testUsers.add(tesUserObj);
        tesUserObj = new TestUsers();
        tesUserObj.setUserName("Shawbori");
        tesUserObj.setAge("47");
        testUsers.add(tesUserObj);
        return testUsers;
    }
}
