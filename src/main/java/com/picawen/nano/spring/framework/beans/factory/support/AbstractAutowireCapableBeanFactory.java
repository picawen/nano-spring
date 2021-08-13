package com.picawen.nano.spring.framework.beans.factory.support;

import com.picawen.nano.spring.framework.beans.BeansException;
import com.picawen.nano.spring.framework.beans.factory.config.BeanDefinition;

/**
 * 自动装配Bean工厂
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * 创建Bean实例
     *
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }
}
