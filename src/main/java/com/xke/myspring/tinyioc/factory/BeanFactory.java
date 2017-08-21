package com.xke.myspring.tinyioc.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.xke.myspring.tinyioc.BeanDefinition;
/**
 * 
 * @author xiekeen
 *
 */
public interface BeanFactory {
	
	
	public Object getBean(String name) throws Exception ;
		
	
	public void registerBeanDefinition(String name,BeanDefinition beanDefinition) throws Exception ;
	
		
	
}
