package com.xke.myspring.tinyioc.beans.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.xke.myspring.tinyioc.beans.BeanDefinition;

public abstract class AbstractBeanFactory implements BeanFactory{
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
	
	private final List<String> beanDefinitionNames = new ArrayList<String>();

	public Object getBean(String name) throws Exception {
		BeanDefinition beanDefinition = beanDefinitionMap.get(name);
		if(beanDefinition == null){
			throw new IllegalArgumentException("no bean name"+name+"is defined");
		}
		Object bean = beanDefinition.getBean();
		if(bean == null )
			bean = doCreateBean(beanDefinition);
		return bean;
	}

	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
		
		beanDefinitionMap.put(name, beanDefinition);
		beanDefinitionNames.add(name);

		
	}
	public void preInstantiateSingletons() throws Exception {
		for(String beanName : beanDefinitionNames){
			getBean(beanName);
		}
		
	}
/**
 * ≥ı ºªØbean
 * @param beanDefinition
 * @return
 * @throws Exception 
 */
	protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
		
	

}
