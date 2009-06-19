package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapMarkerRemovedListener extends EventListener {

	class MapMarkerRemovedEvent extends MapEvent {

		public MapMarkerRemovedEvent(JSObject eventObject) {
			super(eventObject);
		}

		//getMarker ???
	}

	public void onMarkerRemoved(MapMarkerRemovedEvent eventObject);
}
