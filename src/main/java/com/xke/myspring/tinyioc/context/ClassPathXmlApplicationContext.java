package com.xke.myspring.tinyioc.context;

import java.util.Map;

import com.xke.myspring.tinyioc.beans.BeanDefinition;
import com.xke.myspring.tinyioc.beans.factory.AbstractBeanFactory;
import com.xke.myspring.tinyioc.beans.factory.AutowireCapableBeanFactory;
import com.xke.myspring.tinyioc.beans.io.ResourceLoader;
import com.xke.myspring.tinyioc.beans.xml.XmlBeanDefinitionReader;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

	private String configLocation;
	
	public ClassPathXmlApplicationContext(String configLocation) throws Exception{
		this(configLocation,new AutowireCapableBeanFactory());
	}

	public ClassPathXmlApplicationContext(String configLocation2,
			AbstractBeanFactory beanFactory) throws Exception {
		super(beanFactory);
		this.configLocation = configLocation2;
		refresh();
	}

	@Override
	public void refresh() throws Exception {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
		for (Map.Entry<String,BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}
		
	}
	

}
