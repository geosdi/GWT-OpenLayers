package com.eg.gwt.openLayers.client.handler;

import com.eg.gwt.openLayers.client.JSObject;

public class Path extends Point {

	protected Path(JSObject element) {
		super(element);
	}
	
	public static JSObject getJSClass() {
		return PathImpl.getJSClass();
	}

}
