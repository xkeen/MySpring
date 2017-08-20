package com.xke.myspring.tinyioc;
/**
 * ����bean������ע��
 * @author xiekeen
 *
 */
public class PropertyValue {
	private final String name;
	private final Object value;
	
	public PropertyValue(String name, Object value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}
	
	
}