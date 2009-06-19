package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapLayerAddedListener extends EventListener {

	class MapLayerAddedEvent extends MapLayerEvent {

		public MapLayerAddedEvent(JSObject eventObject) {
			super(eventObject);
		}

	}

	public void onLayerAdded(MapLayerAddedEvent eventObject);
}
