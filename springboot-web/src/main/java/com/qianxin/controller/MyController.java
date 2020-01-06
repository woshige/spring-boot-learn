package com.qianxin.controller;

import com.qianxin.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping("/user")
    public User helloUser(){
        User user = new User();
        user.setAge(10);
        user.setName("sunlichao");
        return user;
    }
}
