package com.eg.gwt.openLayers.client.util;

import com.eg.gwt.openLayers.client.OpenLayersWidget;




public class JBoolean extends OpenLayersWidget {

	protected JBoolean(JSObject element) {
		super(element);
	}
	
	public static JBoolean narrowToBooleanElement(JSObject element)
	{
		return ((element == null) || (!JBooleanImpl.isBoolean(element)))?null:new JBoolean(element);
	}
	
	public JBoolean(boolean bool)
	{
		super(JBooleanImpl.create(bool));
	}
	
	public boolean toBoolean()
	{
		return JBooleanImpl.toBoolean(getJSObject());
	}
}
