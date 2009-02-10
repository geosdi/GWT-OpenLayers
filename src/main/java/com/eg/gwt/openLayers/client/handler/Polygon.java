package com.eg.gwt.openLayers.client.handler;

import com.eg.gwt.openLayers.client.util.JSObject;

public class Polygon extends Path {

	protected Polygon(JSObject element) {
		super(element);
	}
	
	public static JSObject getJSClass() {
		return PolygonImpl.getJSClass();
	}

}
