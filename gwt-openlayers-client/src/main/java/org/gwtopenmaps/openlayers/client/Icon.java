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

	/**
	 * @param size - size of the icon image
	 */
	//this method is private in OpenLayers, but also used
	// by the OpenLayers markerResize example, it seems it should be public
	public void setSize(Size size){
		IconImpl.setSize(getJSObject(), size.getJSObject());
	}

	/**
	 * @param url - url for the icon image
	 */
	//private in OpenLayers, but it seems it should be public
	public void setUrl(String url){
		IconImpl.setUrl(getJSObject(), url);
	}
	
	/**
	 * 
	 * @param zIndex
	 */
	public void setZIndex(int zIndex) {
		IconImpl.setZIndex(getJSObject(), zIndex);
	}
	
	public String getZIndex() {
		return IconImpl.getZIndex(getJSObject());
	}

}
