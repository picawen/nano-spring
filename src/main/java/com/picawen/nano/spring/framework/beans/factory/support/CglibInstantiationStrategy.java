package com.picawen.nano.spring.framework.beans.factory.support;

import com.picawen.nano.spring.framework.beans.BeansException;
import com.picawen.nano.spring.framework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * cglib实例化策略
 */
public class CglibInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        try {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(beanDefinition.getBeanClass());
            enhancer.setCallback(new NoOp() {
                @Override
                public int hashCode() {
                    return super.hashCode();
                }
            });
            if (ctor != null) {
                return enhancer.create(ctor.getParameterTypes(), args);
            } else {
                return enhancer.create();
            }
        } catch (Exception e) {
            throw new BeansException("Failed to instantiate [" + beanDefinition.getBeanClass().getName() + "]", e);
        }
    }
}
