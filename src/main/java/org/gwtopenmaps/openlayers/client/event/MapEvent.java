package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class MapEvent extends EventObject {

	protected MapEvent(JSObject eventObject) {
		super(eventObject);
	}

	public Map getSource(){
		JSObject object = getObject();
		return (object!=null)?Map.narrowToMap(object):null;
	}

}
