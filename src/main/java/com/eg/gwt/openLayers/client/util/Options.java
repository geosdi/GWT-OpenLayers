package com.eg.gwt.openLayers.client.util;


/**
 * <p>
 * In javascript it is common to pass options to objects as an object literal. See also:
 *
 * </p>
 * <p>
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

}
