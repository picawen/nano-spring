package com.picawen.nano.spring.framework;

public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public UserService() {
    }

    public void getUserInfo() {
        System.out.println("获取用户信息-" + name);
    }
}
