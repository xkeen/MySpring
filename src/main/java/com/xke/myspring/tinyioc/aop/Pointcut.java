package com.xke.myspring.tinyioc.aop;



public interface Pointcut {
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
