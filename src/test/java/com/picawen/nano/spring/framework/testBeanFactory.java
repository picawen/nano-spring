package com.picawen.nano.spring.framework;

import org.junit.Test;

public class testBeanFactory {

    @Test
    public void testBeanFactory() {
        BeanFactory beanFactory = new BeanFactory();
        // 先注册
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 获取
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.getUserInfo();
    }
}
