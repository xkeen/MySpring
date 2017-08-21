package com.xke.myspring.tinyioc.xml;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.xke.myspring.tinyioc.beans.BeanDefinition;
import com.xke.myspring.tinyioc.beans.io.ResourceLoader;
import com.xke.myspring.tinyioc.beans.xml.XmlBeanDefinitionReader;


public class XmlBeanDefinitionReaderTest {

	@Test
	public void test() throws Exception{
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
		Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
		
		System.out.println(registry.toString());
	}

}
