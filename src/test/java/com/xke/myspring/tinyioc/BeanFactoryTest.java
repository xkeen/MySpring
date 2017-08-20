package com.xke.myspring.tinyioc;

import org.junit.Test;

import com.xke.myspring.tinyioc.factory.AutowireCapableBeanFactory;
import com.xke.myspring.tinyioc.factory.BeanFactory;

public class BeanFactoryTest {
	
	@Test
	public void test() throws Exception{
		//��ʼ��beanfactory
		BeanFactory beanFactory = new AutowireCapableBeanFactory();
		
		//bean�Ķ���
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName("com.xke.myspring.tinyioc.HelloWorldService");
		
		//��������
		PropertyValues propertyValues = new PropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("text", "Hello world"));
		beanDefinition.setPropertyValues(propertyValues);
		
		//ע��bean
		beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
		
		//ͨ��������ȡbean
		HelloWorldService helloWorldService = (HelloWorldService)beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}

}
