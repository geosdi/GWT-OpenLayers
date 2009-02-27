package com.eg.gwt.openLayers.client.util;

import com.eg.gwt.openLayers.client.util.ElementHelper;
import com.eg.gwt.openLayers.client.util.JIntArray;
import com.eg.gwt.openLayers.client.util.JObjectArray;
import com.eg.gwt.openLayers.client.util.JSObject;
import com.eg.gwt.openLayers.client.util.JSObjectWrapper;
import com.google.gwt.user.client.Element;

/**
 * Serves as a base class for making Option objects that must
 * only expose a set of options that are valid for a particular object.
 *
 * Other than that the functions in OptionsBase are protected this class
 * is identical to the {@link Options} class.
 *
 * Use Options to set arbitrary properties on an opaque JSObject.
 *   Options options = new Options();
 *   options.setAttribute("div", div);
 *
 * Use Objects that extend OptionsBase to set class specific properties.
 *   MapOptions mapOptions = new MapOptions();
 *   mapOptions.setProjection("EPSG:28992");
 *   mapOptions.setUnits(MapUnits.METER);
 *   mapOptions.setMaxExtent(new Bounds(12628.0541, 308179.0423, 283594.4779, 611063.1429));
 *   mapOptions.setMasResolutionToAuto();
 *
 * An object like MapOptions can be created using Options, but that is errorprone
 * and requires knowledge of the property names in OpenLayers:
 *   Options options = new Options();
 *   options.setAttribute("projection", "EPSG":28992");
 *   options.setAttribute("units", "m");
 *   options.setAttribute("maxExtent", new Bounds(12628.0541, 308179.0423, 283594.4779, 611063.1429));
 *   options.setAttribute("maxResolution", "auto");
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class OptionsBase extends JSObjectWrapper {

	protected OptionsBase(){
		super(OptionsBaseImpl.create());
		//super((JSObject) JSObject.createObject()); //should work
	}

	protected void setAttribute(String attr, boolean value)
	{
		ElementHelper.setAttribute(getJSObject(), attr, value);
	}

	protected void setAttribute(String attr, int value)
	{
		ElementHelper.setAttribute(getJSObject(), attr, value);
	}

	protected void setAttribute(String attr, int[] value)
	{
		setAttribute(attr, new JIntArray(value).getJSObject());
	}

	protected void setAttribute(String attr, double value)
	{
	   ElementHelper.setAttribute(getJSObject(), attr, value);
	}

	protected void setAttribute(String attr, String value)
	{
		ElementHelper.setAttribute(getJSObject(), attr, value);
	}

	protected void setAttribute(String attr, Element value)
	{
		ElementHelper.setAttribute(getJSObject(), attr, value);
	}

	protected void setAttribute(String attr, JSObject value)
	{
		ElementHelper.setAttribute(getJSObject(), attr, value);
	}

	protected void setAttribute(String attr, JObjectArray value)
	{
		ElementHelper.setAttribute(getJSObject(), attr, value.getJSObject());
	}

	protected String getAttribute(String attr)
	{
		return ElementHelper.getAttribute(getJSObject(), attr);
	}

	protected boolean getAttributeAsBoolean(String attr)
	{
		return ElementHelper.getAttributeAsBoolean(getJSObject(), attr);
	}

	protected double getAttributeAsDouble(String attr)
	{
		return ElementHelper.getAttributeAsDouble(getJSObject(), attr);
	}

	protected Element getAttributeAsElement(String attr)
	{
		return ElementHelper.getAttributeAsElement(getJSObject(), attr);
	}

	protected JSObject getAttributeAsJSObject(String attr)
	{
		return ElementHelper.getAttributeAsJSObject(getJSObject(), attr);
	}

	protected int getAttributeAsInt(String attr)
	{
		return ElementHelper.getAttributeAsInt(getJSObject(), attr);
	}

	//TODO Perhaps move these back to helper methods
	protected int[] getAttributeAsIntArray(String attr)
	{
		return JIntArray.narrowToJIntArray(getAttributeAsJSObject(attr)).toArray();
	}

	protected String[] getAttributes()
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
