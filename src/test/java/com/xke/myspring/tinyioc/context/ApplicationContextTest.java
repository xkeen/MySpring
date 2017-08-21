package com.xke.myspring.tinyioc.context;


import org.junit.Test;

import com.xke.myspring.tinyioc.HelloWorldService;

public class ApplicationContextTest {

	@Test
	public void test() throws Exception {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
		HelloWorldService bean = (HelloWorldService) classPathXmlApplicationContext.getBean("helloWorldService");
		bean.helloWorld();
	}

}
