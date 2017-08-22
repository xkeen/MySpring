package com.xke.myspring.tinyioc.aop;

import static org.junit.Assert.*;

import org.junit.Test;

import com.xke.myspring.tinyioc.HelloWorldService;
import com.xke.myspring.tinyioc.context.ApplicationContext;
import com.xke.myspring.tinyioc.context.ClassPathXmlApplicationContext;

public class JdkDynamicAopProxyTest {

	@Test
	public void test() throws Exception {
		//hello world without aop
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
		HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
		helloWorldService.helloWorld();
		
		//hello world with aop
		//1.设置被代理对象
		AdvisedSupport advisedSupport = new AdvisedSupport();
		TargetSource targetSource = new TargetSource( HelloWorldService.class,helloWorldService);
		advisedSupport.setTargetSource(targetSource);
		
		//2.设置拦截器（advice）
		TimerInterceptor timerInterceptor = new TimerInterceptor();
		advisedSupport.setMethodInterceptor(timerInterceptor);
		
		//3.创建代理（proxy）
		JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
		HelloWorldService helloWorldServiceProxy = (HelloWorldService) jdkDynamicAopProxy.getProxy();
		
		//4.基于AOP的调用
		helloWorldServiceProxy.helloWorld();
	}

}
