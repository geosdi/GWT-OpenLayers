package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;


public class OSMOptions extends JSObjectWrapper {

	//TODO: see if it makes more sense to extend LayerOptions

	protected OSMOptions(JSObject jsObject) {
		super(jsObject);
	}

	public OSMOptions(){
		this(JSObject.createJSObject());
	}

}
