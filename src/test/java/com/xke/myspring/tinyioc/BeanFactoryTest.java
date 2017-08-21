package com.xke.myspring.tinyioc;

import java.awt.HeadlessException;
import java.util.Map;

import org.junit.Test;

import com.xke.myspring.tinyioc.factory.AbstractBeanFactory;
import com.xke.myspring.tinyioc.factory.AutowireCapableBeanFactory;
import com.xke.myspring.tinyioc.factory.BeanFactory;
import com.xke.myspring.tinyioc.io.ResourceLoader;
import com.xke.myspring.tinyioc.xml.XmlBeanDefinitionReader;


public class BeanFactoryTest {
	
/*	@Test
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
	}*/
	
	@Test
	public void testLazy() throws Exception{
		//1.��ȡ����
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
		
		//2.��ʼ��BeanFactory��ע��bean
		AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
		}
		
		//3.��ȡbean
		HelloWorldService helloWorldService = (HelloWorldService)beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}
	
	@Test
	public void testPreInstantiate() throws Exception {
		// 1.��ȡ����
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

		// 2.��ʼ��BeanFactory��ע��bean
		AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}

        // 3.��ʼ��bean
        beanFactory.preInstantiateSingletons();

		// 4.��ȡbean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}
}
