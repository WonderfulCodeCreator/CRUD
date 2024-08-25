package com.example.controller;

import com.example.common.Result;
import com.example.entity.Login;
import com.example.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    private LoginService loginService;

    @PostMapping("/login")
    public Result login(@RequestBody Login login) {
        
        return Result.success();
    }
}
