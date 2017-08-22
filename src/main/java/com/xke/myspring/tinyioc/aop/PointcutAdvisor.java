package com.xke.myspring.tinyioc.aop;

public interface PointcutAdvisor extends Advisor{
	
	Pointcut getPointcut();

}
