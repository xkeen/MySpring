package com.xke.myspring.tinyioc.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.xke.myspring.tinyioc.BeanDefinition;

public abstract class AbstractBeanFactory implements BeanFactory{
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

	public Object getBean(String name) {
		return beanDefinitionMap.get(name).getBean();
	}

	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
		Object bean = doCreateBean(beanDefinition);
		beanDefinition.setBean(bean);
		beanDefinitionMap.put(name, beanDefinition);

		
	}
/**
 * ≥ı ºªØbean
 * @param beanDefinition
 * @return
 * @throws Exception 
 */
	protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
		
	

}
