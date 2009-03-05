package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.event.FeatureAddedListener;
import com.eg.gwt.openLayers.client.layer.Vector;
import com.eg.gwt.openLayers.client.util.JSObject;
import com.eg.gwt.openLayers.client.util.Options;

/**
 *
 *  Don't be suprised by the following:
 *  Upon activating the DrawFeature tool it creates an extra layer
 *  that is used by the handler (the name of this layer reflects this).
 *
 * (tested in OpenLayers 2.7)
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class DrawFeature extends Control {

	protected DrawFeature(JSObject element) {
		super(element);
	}

	public DrawFeature(Vector layer, JSObject handler) {
		this(DrawFeatureImpl.create(layer.getJSObject(), handler));
	}

	//TODO see if these three constructors can be reduced to 1 with DrawFeatureParams object
	//  see SelectFeature

	public DrawFeature(Vector layer, JSObject handler, Options options) {
		this(DrawFeatureImpl.create(layer.getJSObject(), handler, options.getJSObject()));
	}

	public DrawFeature(Vector layer, JSObject handler, FeatureAddedListener listener){
		this(DrawFeatureImpl.create(layer.getJSObject(), handler, listener));
	}

	public DrawFeature(Vector layer, JSObject handler, FeatureAddedListener listener, Options options){
		this(DrawFeatureImpl.create(layer.getJSObject(), handler, listener, options.getJSObject()));
	}
}
