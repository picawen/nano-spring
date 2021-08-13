package com.picawen.nano.spring.framework.beans.factory;

import com.picawen.nano.spring.framework.beans.BeansException;

/**
 * Bean工厂接口定义
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;
}
