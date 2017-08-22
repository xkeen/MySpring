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
		//1.���ñ��������
		AdvisedSupport advisedSupport = new AdvisedSupport();
		TargetSource targetSource = new TargetSource( HelloWorldService.class,helloWorldService);
		advisedSupport.setTargetSource(targetSource);
		
		//2.������������advice��
		TimerInterceptor timerInterceptor = new TimerInterceptor();
		advisedSupport.setMethodInterceptor(timerInterceptor);
		
		//3.��������proxy��
		JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
		HelloWorldService helloWorldServiceProxy = (HelloWorldService) jdkDynamicAopProxy.getProxy();
		
		//4.����AOP�ĵ���
		helloWorldServiceProxy.helloWorld();
	}

}
