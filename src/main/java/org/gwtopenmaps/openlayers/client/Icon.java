package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * 
 * @author Erdem Gunay
 *
 */
public class Icon extends OpenLayersObjectWrapper {

	protected Icon(JSObject element) {
		super(element);
	}
	
	public static Icon narrowToIcon(JSObject element)
	{
		return (element == null)?null:new Icon(element);
	}
	
	
	public Icon(String url, Size size) {
		this(IconImpl.create(url, size.getJSObject()));
	}

	public Icon(String url, Size size, Pixel offset) {
		this(IconImpl.create(url, size.getJSObject(), offset.getJSObject()));
	}

}
