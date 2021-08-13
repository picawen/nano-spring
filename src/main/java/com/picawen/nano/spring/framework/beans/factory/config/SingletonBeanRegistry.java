package com.picawen.nano.spring.framework.beans.factory.config;

/**
 * 单例Bean注册器接口定义
 */
public interface SingletonBeanRegistry {
    /**
     * 获取单例Bean
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);
}
