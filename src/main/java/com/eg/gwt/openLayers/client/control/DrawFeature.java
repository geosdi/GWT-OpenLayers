package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.layer.Vector;
import com.eg.gwt.openLayers.client.util.JSObject;

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

	//FIXME: make call typesafe (JSObject -> VectorFeature) by using same trick as in MousePositionImpl
	// also for select feature
	public interface FeatureAddedListener {
		void onFeatureAdded(JSObject vectorFeature);
	}

	protected DrawFeature(JSObject element) {
		super(element);
	}

	//FIXME: make method's with handler params type safe: let handler be of handler type!
	public DrawFeature(Vector layer, JSObject handler) {
		this(DrawFeatureImpl.create(layer.getJSObject(), handler));
	}

	public DrawFeature(Vector layer, JSObject handler, DrawFeatureOptions options){
		this(DrawFeatureImpl.create(layer.getJSObject(), handler, options.getJSObject()));
	}

}
