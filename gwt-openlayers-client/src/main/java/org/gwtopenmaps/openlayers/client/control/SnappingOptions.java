package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

public class SnappingOptions extends JSObjectWrapper {

	public SnappingOptions(JSObject object) {
		super(object);
	}
	
	public SnappingOptions() {
		this(JSObject.createJSArray());
	}
	
	/**
	 * Snap to closest feature in first target layer that applies.  Default is true.  If false, all features in all target layers will be checked and the closest feature in all target layers will be chosen.  The greedy property determines if the order of the target layers is significant.  By default, the order of the target layers is significant where layers earlier in the target layer list have precedence over layers later in the list.  Within a single layer, the closest feature is always chosen for snapping.  This property only determines whether the search for a closer feature continues after an eligible feature is found in a target layer.
	 * @param greedy
	 */
	public void setGreedy(boolean greedy) {
		this.getJSObject().setProperty("greedy", greedy);
	}
	
	public void setTargets(Vector[] vector) {
		JSObject arrayVector = JSObject.createJSArray();
		for(int i=0; i<vector.length; i++) {
			arrayVector.setProperty(i+"", vector[i].getJSObject());
		}
		this.getJSObject().setProperty("targets", arrayVector);
	}
	
	public void setLayer(Vector vector) {
		this.getJSObject().setProperty("layer", vector.getJSObject());
	}
	
	public void setDefaults(Vector vector) {
		this.getJSObject().setProperty("defaults", vector.getJSObject());
	}
}
