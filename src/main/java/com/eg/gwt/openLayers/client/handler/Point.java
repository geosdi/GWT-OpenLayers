package com.eg.gwt.openLayers.client.handler;

import com.eg.gwt.openLayers.client.util.JSObject;

public class Point extends Handler {

	protected Point(JSObject element) {
		super(element);
	}
	
	public static JSObject getJSClass() {
		return PointImpl.getJSClass();
	}

}
