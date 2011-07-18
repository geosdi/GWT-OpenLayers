package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class MarkersOptions extends JSObjectWrapper {

	protected MarkersOptions(JSObject jsObject) {
		super(jsObject);
	}

	public MarkersOptions(){
		this(JSObject.createJSObject());
	}
	
	/**
	 * 
	 * @param maxZoomLevel
	 */
	public void setMaxZoomLevel(int maxZoomLevel) {
		getJSObject().setProperty("maxZoomLevel", maxZoomLevel);
	}

	// What kind of options has Markers?
}
