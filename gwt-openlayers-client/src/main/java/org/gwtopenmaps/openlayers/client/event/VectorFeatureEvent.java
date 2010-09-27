package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class VectorFeatureEvent extends VectorEvent {

	protected VectorFeatureEvent(JSObject eventObject) {
		super(eventObject);
	}

	public VectorFeature getVectorFeature(){
		JSObject object = getJSObject().getProperty("feature");
		return (object!=null)?VectorFeature.narrowToVectorFeature(object):null;
	}

}
