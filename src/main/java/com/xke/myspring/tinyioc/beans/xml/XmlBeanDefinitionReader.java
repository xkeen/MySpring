package com.xke.myspring.tinyioc.beans.xml;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.xke.myspring.tinyioc.BeanReference;
import com.xke.myspring.tinyioc.beans.AbstractBeanDefinitionReader;
import com.xke.myspring.tinyioc.beans.BeanDefinition;
import com.xke.myspring.tinyioc.beans.PropertyValue;
import com.xke.myspring.tinyioc.beans.PropertyValues;
import com.xke.myspring.tinyioc.beans.io.ResourceLoader;
/**
 * xml解析bean
 * @author xiekeen
 *
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader{

	public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
		super(resourceLoader);
		
	}
	
	public void loadBeanDefinitions(String location) throws Exception {
		
		InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
		doLoadBeanDefinitions(inputStream);
	}

	protected void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse(inputStream);
		//解析bean
		registerBeanDefinitions(document);
		inputStream.close();
		
	}

	public void registerBeanDefinitions(Document document) {
		Element root = document.getDocumentElement();
		//System.out.println(root.getNodeName());
		parseBeanDefinitions(root);
		
	}

	protected void parseBeanDefinitions(Element root) {
		NodeList nodeList = root.getChildNodes();
		
		for(int i = 0 ; i< nodeList.getLength();i++){
			Node node = nodeList.item(i);
			
			if(node instanceof Element){
				Element element = (Element)node;
				processBeanDefinition(element);
			}
			
		}
		
	}
/**
 * 解析bean节点
 * @param element
 */
	protected void processBeanDefinition(Element element) {
		String name = element.getAttribute("name");
		String className = element.getAttribute("class");
		BeanDefinition beanDefinition = new BeanDefinition();
		processProperty(element,beanDefinition);
		beanDefinition.setBeanClassName(className);
		getRegistry().put(name, beanDefinition);
		
		
	}
/**
 * 解析bean节点的属性值
 * @param element
 * @param beanDefinition
 */
	private void processProperty(Element element, BeanDefinition beanDefinition) {
		NodeList propertyNode = element.getElementsByTagName("property");
		for(int i = 0; i < propertyNode.getLength();i++){
			Node node = propertyNode.item(i);
			if(node instanceof Element){
				Element propertryEle = (Element) node;
				String name = propertryEle.getAttribute("name");
				String value = propertryEle.getAttribute("value");
				if(value != null && value.length() > 0){
					beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));					
				}else {
					String ref = propertryEle.getAttribute("ref");
					if(ref == null || ref.length() == 0){
						throw new IllegalArgumentException("Configuration problem: <property> element for property '"
								+ name + "' must specify a ref or value");
					}
					BeanReference beanReference = new BeanReference(ref);
					beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
				}
				
			}
		}
		
	}
	
	
}
