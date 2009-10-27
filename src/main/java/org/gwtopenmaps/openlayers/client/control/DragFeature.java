package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JSObject;

public class DragFeature extends Control {
    public DragFeature(Vector layer) {
    	this(DragFeatureImpl.create(layer.getJSObject()));
    }
    public DragFeature(Vector layer, DragFeatureOptions options) {
    	this(DragFeatureImpl.create(layer.getJSObject(), options.getJSObject()));
    }
	public DragFeature(JSObject element) {
		super(element);
	}
}
