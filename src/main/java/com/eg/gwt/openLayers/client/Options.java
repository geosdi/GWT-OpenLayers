package com.eg.gwt.openLayers.client;


import com.eg.gwt.openLayers.client.util.ElementHelper;
import com.eg.gwt.openLayers.client.util.JIntArray;
import com.eg.gwt.openLayers.client.util.JObjectArray;
import com.eg.gwt.openLayers.client.util.JSObject;
import com.google.gwt.user.client.Element;

/**
 *
 * @author Erdem Gunay
 *
 */
public class Options extends OpenLayersWidget {

	protected Options(JSObject element) {
		super(element);
	}

	public static Options narrowToGOptionBase(JSObject element)
	{
		return (element == null)?null: new Options(element);
	}

	public Options()
	{
		this(OptionsImpl.create());
	}

	public void setAttribute(String attr, boolean value)
	{
		ElementHelper.setAttribute(getJSObject(), attr, value);
	}

	public void setAttribute(String attr, int value)
	{
		ElementHelper.setAttribute(getJSObject(), attr, value);
	}

	public void setAttribute(String attr, int[] value)
	{
		setAttribute(attr, new JIntArray(value).getJSObject());
	}

	public void setAttribute(String attr, double value)
	{
	   ElementHelper.setAttribute(getJSObject(), attr, value);
	}

	public void setAttribute(String attr, String value)
	{
		ElementHelper.setAttribute(getJSObject(), attr, value);
	}

	public void setAttribute(String attr, Element value)
	{
		ElementHelper.setAttribute(getJSObject(), attr, value);
	}

	public void setAttribute(String attr, JSObject value)
	{
		ElementHelper.setAttribute(getJSObject(), attr, value);
	}

	public void setAttribute(String attr, JObjectArray value)
	{
		ElementHelper.setAttribute(getJSObject(), attr, value.getJSObject());
	}

	public String getAttribute(String attr)
	{
		return ElementHelper.getAttribute(getJSObject(), attr);
	}

	public boolean getAttributeAsBoolean(String attr)
	{
		return ElementHelper.getAttributeAsBoolean(getJSObject(), attr);
	}

	public double getAttributeAsDouble(String attr)
	{
		return ElementHelper.getAttributeAsDouble(getJSObject(), attr);
	}

	public Element getAttributeAsElement(String attr)
	{
		return ElementHelper.getAttributeAsElement(getJSObject(), attr);
	}

	public JSObject getAttributeAsJSObject(String attr)
	{
		return ElementHelper.getAttributeAsJSObject(getJSObject(), attr);
	}

	public int getAttributeAsInt(String attr)
	{
		return ElementHelper.getAttributeAsInt(getJSObject(), attr);
	}

	//TODO Perhaps move these back to helper methods
	public int[] getAttributeAsIntArray(String attr)
	{
		return JIntArray.narrowToJIntArray(getAttributeAsJSObject(attr)).toArray();
	}

	public String[] getAttributes()
	{
		JSObject attributes = ElementHelper.getAttributes(getJSObject());

		int size = ElementHelper.arrayLength(attributes);
		String[] rtn = new String[size];

		for(int i = 0; i < size; i++)
		{
			JSObject elem = ElementHelper.getElementFromArray(attributes, i);
			rtn[i] = ElementHelper.getAttributeName(elem);
		}

		return rtn;

	}
}
