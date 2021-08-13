package com.picawen.nano.spring.framework;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("1", "A");
        hashMap.put("2", "B");
        hashMap.put("3", "C");
    }

    public String getUserName(String uId) {
        return hashMap.get(uId);
    }
}
