/**
 * 
 */
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Lorenzo Amato - CNR IMAA geoSDI Group
 * @email lorenzo.amato@geosdi.org
 */
public class Snapping  extends Control {

	protected Snapping(JSObject element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public Snapping(){
		this(SnappingImpl.create());
	}
	
	public Snapping(SnappingOptions options){
		this(SnappingImpl.create(options.getJSObject()));
	}
	
	public void addTarget(SnappingTarget target){
		SnappingImpl.addTarget(this.getJSObject(), target.getJSObject());
	}
	public void removeTarget(SnappingTarget target){
		SnappingImpl.removeTarget(this.getJSObject(), target.getJSObject());
	}
	
}
