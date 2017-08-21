package com.xke.myspring.tinyioc.beans;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {
	private final List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();
	
	public void addPropertyValue(PropertyValue pValue) {
		this.propertyValueList.add(pValue);
		
	}
	public List<PropertyValue> getPropertyValues(){
		return this.propertyValueList;
	}
}
