package com.picawen.nano.spring.framework.beans.factory.support;

import com.picawen.nano.spring.framework.beans.BeansException;
import com.picawen.nano.spring.framework.beans.factory.BeanFactory;
import com.picawen.nano.spring.framework.beans.factory.config.BeanDefinition;

/**
 * 抽象Bean工厂（模板模式）
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
