package com.xke.myspring.tinyioc.xml;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.xke.myspring.tinyioc.BeanDefinition;
import com.xke.myspring.tinyioc.io.ResourceLoader;


public class XmlBeanDefinitionReaderTest {

	@Test
	public void test() throws Exception{
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
		Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
		
		System.out.println(registry.toString());
	}

}
