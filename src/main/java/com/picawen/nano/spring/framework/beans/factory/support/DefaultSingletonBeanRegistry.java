package com.picawen.nano.spring.framework.beans.factory.support;

import com.picawen.nano.spring.framework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例Bean默认实现
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjs = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjs.get(beanName);
    }

    protected void addSingleton(String beanName, Object obj) {
        singletonObjs.put(beanName, obj);
    }
}
