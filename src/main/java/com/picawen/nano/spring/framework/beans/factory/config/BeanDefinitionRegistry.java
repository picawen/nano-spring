package com.picawen.nano.spring.framework.beans.factory.config;

/**
 * Bean定义注册
 */
public interface BeanDefinitionRegistry {
    /**
     * 注册BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
