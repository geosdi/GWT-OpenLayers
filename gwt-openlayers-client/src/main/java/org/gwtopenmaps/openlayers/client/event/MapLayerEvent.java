package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class MapLayerEvent extends MapEvent {

	protected MapLayerEvent(JSObject eventObject) {
		super(eventObject);
	}

	public Layer getLayer(){
		JSObject object = getJSObject().getProperty("layer");
		return (object!=null)? Layer.narrowToLayer(object): null;
	}

}
