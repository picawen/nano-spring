package com.picawen.nano.spring.framework;

import com.picawen.nano.spring.framework.beans.factory.config.BeanDefinition;
import com.picawen.nano.spring.framework.beans.factory.support.DefaultListableBeanFactory;

public class Test {

    @org.junit.Test
    public void testBeanFactory() {
        String beanName = "userService";

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition(beanName, beanDefinition);

        UserService userService1 = (UserService) beanFactory.getBean(beanName,"666");
        userService1.getUserInfo();
    }
}
