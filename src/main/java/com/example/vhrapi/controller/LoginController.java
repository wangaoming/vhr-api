package com.example.vhrapi.controller;

import com.example.vhrapi.model.RespBean;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "LoginController", tags = {"登录管理"})
public class LoginController {
//    测试
@GetMapping("/hello")
public String hello() {
    return "hello";
}
    @GetMapping("/login")
    public RespBean login() {
        return RespBean.error("尚未登录，请登录");
    }
}