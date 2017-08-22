package com.xke.myspring.tinyioc.aop;

public interface ClassFilter {
	
	boolean matches(Class targetClass);
}
