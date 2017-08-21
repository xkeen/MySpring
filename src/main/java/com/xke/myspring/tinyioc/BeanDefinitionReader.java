package com.xke.myspring.tinyioc;

public interface BeanDefinitionReader {
	void loadBeanDefinitions(String location) throws Exception;
}
