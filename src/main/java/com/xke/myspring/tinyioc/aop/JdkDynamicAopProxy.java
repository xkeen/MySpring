package com.xke.myspring.tinyioc.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.aopalliance.intercept.MethodInterceptor;


public class JdkDynamicAopProxy implements AopProxy,InvocationHandler {
	
	private AdvisedSupport advised;

	public JdkDynamicAopProxy(AdvisedSupport advised) {
		this.advised = advised;
	}


	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
		return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource()
				.getTarget(), method, args));
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(getClass().getClassLoader(),new Class[] { advised.getTargetSource()
				.getTargetClass() }, this);
	}
	
	

}
