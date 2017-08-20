package com.xke.myspring.tinyioc.factory;

import java.lang.reflect.Field;

import com.xke.myspring.tinyioc.BeanDefinition;
import com.xke.myspring.tinyioc.PropertyValue;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {

	@Override
	protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {

			Object bean = createBeanInstance(beanDefinition);
			applyPropertyValue(bean, beanDefinition);
			return bean;

	
	}
	protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
		return beanDefinition.getBeanClass().newInstance();
	}
	protected void applyPropertyValue(Object bean,BeanDefinition mbd) throws Exception{
		for(PropertyValue propertyValue: mbd.getPropertyValues().getPropertyValues()){
			Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
			declaredField.setAccessible(true);
			declaredField.set(bean, propertyValue.getValue());
		}
		
	}

}
