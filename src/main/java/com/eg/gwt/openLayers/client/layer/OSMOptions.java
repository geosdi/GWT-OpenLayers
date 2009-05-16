package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.util.JSObject;
import com.eg.gwt.openLayers.client.util.JSObjectWrapper;


public class OSMOptions extends JSObjectWrapper {

	//TODO: see if it makes more sense to extend LayerOptions

	protected OSMOptions(JSObject jsObject) {
		super(jsObject);
	}

	public OSMOptions(){
		this(JSObject.createJSObject());
	}

}
