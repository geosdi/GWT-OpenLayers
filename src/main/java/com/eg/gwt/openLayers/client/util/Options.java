package com.eg.gwt.openLayers.client.util;


import com.google.gwt.user.client.Element;

/**
 * <p>
 * In javascript it is common to pass options to objects as an object literal.
 * For example:
 * <pre>
 *   map = new OpenLayers.Map('map',
 *     { projection: "EPSG:32632",
 *       maxExtent :  new OpenLayers.Bounds(166021.4431, 0.0000, 833978.5569, 9329005.1825),
 *       maxResolution : "auto",
 *       units : "m"
 *     })
 * </pre>
 * The second argument is an object literal with the properties.
 * </p>
 * <p>
 * </p>
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur
 */
public class Options extends JSObjectWrapper {

	protected Options(JSObject element) {
		super(element);
	}

	public Options()
	{
		this(JSObject.createJSObject());
	}

	/**
	 * @deprecated
	 */
	public void setAttribute(String attr, boolean value)
	{
		ElementHelper.setAttribute(getJSObject(), attr, value);
	}

	/**
	 * @deprecated
	 */
	public void setAttribute(String attr, int value)
	{
		ElementHelper.setAttribute(getJSObject(), attr, value);
	}

	/**
	 *
	 */
	public void setAttribute(String attr, int[] value)
	{
		setAttribute(attr, new JIntArray(value).getJSObject());
	}

	/**
	 * @deprecated
	 */
	public void setAttribute(String attr, double value)
	{
	   ElementHelper.setAttribute(getJSObject(), attr, value);
	}

	/**
	 * @deprecated
	 */
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
