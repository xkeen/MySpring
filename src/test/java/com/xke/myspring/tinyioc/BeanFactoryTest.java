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
	}*/
	
	@Test
	public void testLazy() throws Exception{
		//1.读取配置
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
		
		//2.初始化BeanFactory并注册bean
		AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
		}
		
		//3.获取bean
		HelloWorldService helloWorldService = (HelloWorldService)beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}
	
	@Test
	public void testPreInstantiate() throws Exception {
		// 1.读取配置
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

		// 2.初始化BeanFactory并注册bean
		AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}

        // 3.初始化bean
        beanFactory.preInstantiateSingletons();

		// 4.获取bean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}
}
