package com.picawen.nano.spring.framework;

import com.picawen.nano.spring.framework.beans.factory.PropertyValue;
import com.picawen.nano.spring.framework.beans.factory.PropertyValues;
import com.picawen.nano.spring.framework.beans.factory.config.BeanDefinition;
import com.picawen.nano.spring.framework.beans.factory.config.BeanReference;
import com.picawen.nano.spring.framework.beans.factory.support.DefaultListableBeanFactory;

public class Test {

    @org.junit.Test
    public void testBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uid", "1"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.getUserInfo();
    }
}
