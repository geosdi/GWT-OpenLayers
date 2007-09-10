package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.LonLat;

/**
 * 
 * @author Erdem Gunay
 *
 */
public class Canvas extends Layer {

	protected Canvas(JSObject element) {
		super(element);
	}

	public Canvas(String name) {
		this(CanvasImpl.create(name));
	}
	
	public void drawLine(LonLat p1, LonLat p2) {
		CanvasImpl.drawLine(getJSObject(), p1.getJSObject(), p2.getJSObject());
	}
}
