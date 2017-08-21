package com.xke.myspring.tinyioc.beans;

import java.util.HashMap;
import java.util.Map;

import com.xke.myspring.tinyioc.beans.io.ResourceLoader;

/**
 * ¥”≈‰÷√÷–∂¡»°BeanDefinitionReader
 * @author xiekeen
 *
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
	
	private Map<String, BeanDefinition> registry;
	
	private ResourceLoader resourceLoader;

	protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
		this.registry = new HashMap<String, BeanDefinition>();
		this.resourceLoader = resourceLoader;
	}

	public Map<String, BeanDefinition> getRegistry() {
		return registry;
	}

	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}
	


}
