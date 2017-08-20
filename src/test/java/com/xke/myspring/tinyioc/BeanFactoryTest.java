package com.xke.myspring.tinyioc;

import org.junit.Test;

import com.xke.myspring.tinyioc.factory.AutowireCapableBeanFactory;
import com.xke.myspring.tinyioc.factory.BeanFactory;

public class BeanFactoryTest {
	
	@Test
	public void test() throws Exception{
		//初始化beanfactory
		BeanFactory beanFactory = new AutowireCapableBeanFactory();
		
		//bean的定义
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName("com.xke.myspring.tinyioc.HelloWorldService");
		
		//设置属性
		PropertyValues propertyValues = new PropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("text", "Hello world"));
		beanDefinition.setPropertyValues(propertyValues);
		
		//注册bean
		beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
		
		//通过类名获取bean
		HelloWorldService helloWorldService = (HelloWorldService)beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}

}
