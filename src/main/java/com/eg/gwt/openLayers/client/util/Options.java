package com.eg.gwt.openLayers.client.util;


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
 * A {@link JSObject} allows properties to be set on it, and to be get from it. Therefore an options
 * object can be a JSObject wrapper, and getter and setter methods for specific Options objects
 * can use getJSOpject().setProperty(...) to set properties and getJSObject().getProperty(...), or
 * getJSObject.getPropertyAsXxx(...) to get properties.
 * </p>
 * <p>
 * Since the getJSObject() is public any properties can be set. However, you are on your own
 * if you use this to work around limitations of the current GWT-OL API.
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
	 *@deprecated
	 */
	public void setAttribute(String attr, int[] value)
	{
		getJSObject().setProperty(attr, new JIntArray(value).getJSObject());
	}

	//TODO Perhaps move these back to helper methods
	/*
	public int[] getAttributeAsIntArray(String attr)
	{
		return JIntArray.narrowToJIntArray(getAttributeAsJSObject(attr)).toArray();
	}
	*/

	/**
	 *@deprecated
	 */
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
