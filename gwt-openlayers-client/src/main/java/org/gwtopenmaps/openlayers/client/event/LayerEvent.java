package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class LayerEvent extends EventObject {

	protected LayerEvent(JSObject eventObject) {
		super(eventObject);
	}

	public Layer getSource(){
		JSObject object = getSourceJSObject();
		return (object!=null)?Layer.narrowToLayer(object):null;
	}

}
