package com.picawen.nano.spring.framework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.picawen.nano.spring.framework.beans.BeansException;
import com.picawen.nano.spring.framework.beans.factory.PropertyValue;
import com.picawen.nano.spring.framework.beans.factory.config.BeanDefinition;
import com.picawen.nano.spring.framework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * 自动装配Bean工厂
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibInstantiationStrategy();

    /**
     * 创建Bean实例
     *
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = this.createBeanInstance(beanName, beanDefinition, args);
            // 填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Constructor ctor = null;
        Class<?> clazz = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> c : declaredConstructors) {
            if (args != null && c.getParameterTypes().length == args.length) {
                ctor = c;
                break;
            }
        }
        return instantiationStrategy.instantiate(beanDefinition, beanName, ctor, args);
    }

    /**
     * Bean 属性填充
     *
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            for (PropertyValue pv : beanDefinition.getPropertyValues().getPropertyValues()) {
                String name = pv.getName();
                Object value = pv.getValue();
                if (value instanceof BeanReference) {
                    // bean1依赖于bean2,先获取bean2的实例
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values:" + beanName);
        }
    }

}
