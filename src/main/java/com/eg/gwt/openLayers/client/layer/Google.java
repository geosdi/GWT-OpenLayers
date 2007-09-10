package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.LonLat;

/**
 * 
 * @author Erdem Gunay
 *
 */
public class Google extends Layer {

	protected Google(JSObject element) {
		super(element);
	}

	public Google(String name) {
		this(GoogleImpl.create(name));
	}
	
}
