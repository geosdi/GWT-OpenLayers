package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.Marker;

/**
 * 
 * @author Erdem Gunay
 * 	   Wayne Fang - Refractions Research
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
	
	public void removeMarker(Marker marker) {
		MarkersImpl.removeMarker(getJSObject(), marker.getJSObject());
	}
	
	public void destroy() {
		MarkersImpl.destroy(getJSObject());
	}
}
