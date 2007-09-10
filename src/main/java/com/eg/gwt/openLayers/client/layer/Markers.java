package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.Marker;

/**
 * 
 * @author Erdem Gunay
 *
 */
public class Markers extends Layer {

	protected Markers(JSObject element) {
		super(element);
	}

	public Markers(String name) {
		this (MarkersImpl.create(name));
	}
	
	public void addMarker(Marker marker) {
		MarkersImpl.addMarker(getJSObject(), marker.getJSObject());
	}
	
}
