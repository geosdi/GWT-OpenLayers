package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.OpenLayersWidget;
import com.eg.gwt.openLayers.client.Options;

public class Vector extends Layer {

	protected Vector(JSObject element) {
		super(element);
	}

	public Vector(String name) {
		this(VectorImpl.create(name));
	}
	
	public Vector(String name, Options options) {
		this(VectorImpl.create(name, options.getJSObject()));
	}
}
