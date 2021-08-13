package com.picawen.nano.spring.framework;

public class UserService {

    private String uid;

    private UserDao userDao;

    public void getUserInfo() {
        System.out.println("获取用户信息:" + userDao.getUserName(uid));
    }
}
