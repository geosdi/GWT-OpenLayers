/**
 * 
 */
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Lorenzo Amato - CNR IMAA geoSDI Group
 * @email lorenzo.amato@geosdi.org
 */
public class SnappingOptions extends ControlOptions {

	/**
	 * Property: greedy {Boolean} Snap to closest feature in first layer with an
	 * eligible feature. Default is true.
	 */
	public void setGreedy(boolean greedy) {
		getJSObject().setProperty("greedy", greedy);
	}

	public boolean getGreedy() {
		return getJSObject().getPropertyAsBoolean("greedy");
	}

	/**
	 * Property: layer {<OpenLayers.Layer.Vector>} The current editable layer.
	 * Set at construction or after construction with <setLayer>.
	 */
	public void setLayer(Vector layer) {
		getJSObject().setProperty("layer", layer.getJSObject());
	}

	public Vector getLayer() {
		return Vector.narrowToVector(getJSObject().getProperty("layer"));
	}

	/** targets - {Array(OpenLayers.Layer.Vector)} A list of vector layers
    *     the defaults from the <defaults>
    *     property will apply.  The editable layer itself may be a target
    *     layer - allowing newly created or edited features to be snapped to
    *     existing features from the same layer.  If no targets are provided
    *     the layer given in the constructor (as <layer>) will become the
    *     initial target.
	**/
	public void setTargets(Vector[] targets) {
		JSObject[] jsObjects = new JSObject[targets.length];
		for (int i = 0; i < targets.length; i++) {
			jsObjects[i] = targets[i].getJSObject();
		}
		JObjectArray array = new JObjectArray(jsObjects);
		getJSObject().setProperty("targets", array.getJSObject());
	}
	/** targets - {Array(Object)} A list of objects for
	    *     configuring target layers.  See valid properties of the target
	    *     objects below.  If the items in the targets list are vector layers
	    *     (instead of configuration objects), the defaults from the <defaults>
	    *     property will apply.  The editable layer itself may be a target
	    *     layer - allowing newly created or edited features to be snapped to
	    *     existing features from the same layer.  If no targets are provided
	    *     the layer given in the constructor (as <layer>) will become the
	    *     initial target.
		**/
	public void setTargets(SnappingTarget[] targets){
		JSObject[] jsObjects = new JSObject[targets.length];
		for (int i = 0; i < targets.length; i++) {
			jsObjects[i] = targets[i].getJSObject();
		}
		JObjectArray array = new JObjectArray(jsObjects);
		getJSObject().setProperty("targets", array.getJSObject());
	}

}
