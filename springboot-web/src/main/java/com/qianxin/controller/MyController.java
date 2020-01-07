package com.qianxin.controller;

import com.qianxin.mapper.UserMapper;
import com.qianxin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
public class MyController {
    @Autowired
    UserMapper mapper;

    @RequestMapping("/user")
    public User helloUser() {
        User user = new User();
        user.setAge(10);
        user.setUsername("sunlichao");
        return user;
    }

    @RequestMapping("/find")
    public User find() {
        return null;
    }

    @RequestMapping("/uid")
    public UUID findUid(@RequestParam("username") String username, HttpSession session) {
        System.out.println(username);
        UUID id = (UUID) session.getAttribute(username);
        System.out.println(id);
        if (id == null) {
            id = UUID.randomUUID();
        }
        session.setAttribute(username, id);
        return id;
    }
}
