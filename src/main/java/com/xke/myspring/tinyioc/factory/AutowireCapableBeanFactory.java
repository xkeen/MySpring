package com.xke.myspring.tinyioc.factory;

import java.lang.reflect.Field;

import com.xke.myspring.tinyioc.BeanDefinition;
import com.xke.myspring.tinyioc.BeanReference;
import com.xke.myspring.tinyioc.PropertyValue;
/**
 * 可自动装配内容的beanfactory
 * @author xiekeen
 *
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

	@Override
	protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {

			Object bean = createBeanInstance(beanDefinition);
			beanDefinition.setBean(bean);
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
			//获取性质对象
			Object value = propertyValue.getValue();
			//如果是注入另一个bean
			if(value instanceof BeanReference){
				BeanReference beanReference = (BeanReference)value;
				value = getBean(beanReference.getName());
			}
			declaredField.set(bean, value);
		}
		
	}

}
