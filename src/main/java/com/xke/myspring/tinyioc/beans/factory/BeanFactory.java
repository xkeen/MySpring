package com.xke.myspring.tinyioc.beans.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.xke.myspring.tinyioc.beans.BeanDefinition;
/**
 * 
 * @author xiekeen
 *
 */
public interface BeanFactory {
	
	
	public Object getBean(String name) throws Exception ;
		
	
	//public void registerBeanDefinition(String name,BeanDefinition beanDefinition) throws Exception ;
	
		
	
}
