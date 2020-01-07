package com.qianxin.pojo;

import org.springframework.cache.annotation.Cacheable;

public class User {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Integer age;
    private String username;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", username='" + username + '\'' +
                '}';
    }

    @Cacheable(value = {"simpleCache"})
    public String getMessage(Integer integer) {
        System.out.println("getMessage has been executed");
        if (integer == 1) {
            return "user1";
        } else {
            return "user2";
        }
    }
}
