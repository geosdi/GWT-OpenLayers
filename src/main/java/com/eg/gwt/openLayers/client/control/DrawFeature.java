package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.Options;
import com.eg.gwt.openLayers.client.layer.Vector;
import com.google.gwt.user.client.Element;

/**
 * 
 * @author Erdem Gunay
 *
 */
public class DrawFeature extends Control {

	protected DrawFeature(JSObject element) {
		super(element);
	}

	public DrawFeature(Vector layer, JSObject handler) {
		this(DrawFeatureImpl.create(layer.getJSObject(), handler));
	}

	public DrawFeature(Vector layer, JSObject handler, Options options) {
		this(DrawFeatureImpl.create(layer.getJSObject(), handler, options.getJSObject()));
	}
	
}
