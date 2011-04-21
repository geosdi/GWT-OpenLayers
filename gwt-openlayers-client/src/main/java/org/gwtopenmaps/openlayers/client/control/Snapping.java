package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class Snapping extends Control {

	public Snapping(JSObject options) {
		super(SnappingImpl.create(options));
	}
	
	public Snapping(SnappingOptions options) {
		this(options.getJSObject());
	}
	
	public boolean activate() {
		return SnappingImpl.activate(this.getJSObject());
	}
	
	public boolean deactivate() {
		return SnappingImpl.deactivate(this.getJSObject());
	}
}
