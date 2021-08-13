package com.picawen.nano.spring.framework.beans.factory;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {

    private final List<PropertyValue> propertyValues = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValues.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValues.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        return propertyValues.stream().filter(pv -> pv.getName().equals(propertyName)).findFirst().orElse(null);
    }
}
