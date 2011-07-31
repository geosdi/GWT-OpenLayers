package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JSObject;

public class Snapping extends Control {

	public Snapping(JSObject options) {
		super(SnappingImpl.create(options));
	}
	
	public Snapping(SnappingOptions options) {
		this(options.getJSObject());
	}
	
	public Snapping() {
		super(SnappingImpl.create());
	}
	
	public boolean activate() {
		return SnappingImpl.activate(this.getJSObject());
	}
	
	public boolean deactivate() {
		return SnappingImpl.deactivate(this.getJSObject());
	}
	
	public void setLayer(Vector vector) {
		SnappingImpl.setLayer(this.getJSObject(), vector.getJSObject());
	}
	
	public void setTargetLayer(Vector vector) {
		SnappingImpl.addTargetLayer(this.getJSObject(), vector.getJSObject());
	}
	
	public void removeTargetLayer(Vector vector) {
		SnappingImpl.removeTargetLayer(this.getJSObject(), vector.getJSObject());
	}
	
	public void addTarget(SnappingTarget target){
		SnappingImpl.addTarget(this.getJSObject(), target.getJSObject());
	}
	public void removeTarget(SnappingTarget target){
		SnappingImpl.removeTarget(this.getJSObject(), target.getJSObject());
	}
	
}
