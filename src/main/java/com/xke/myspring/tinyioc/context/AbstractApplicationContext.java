package com.xke.myspring.tinyioc.context;

import com.xke.myspring.tinyioc.beans.factory.AbstractBeanFactory;

public abstract class AbstractApplicationContext implements ApplicationContext {
	
	protected AbstractBeanFactory beanFactory;
	
	
	public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}
	
	public void refresh() throws Exception{
	}

	public Object getBean(String name) throws Exception {
		return beanFactory.getBean(name);
	}


}
