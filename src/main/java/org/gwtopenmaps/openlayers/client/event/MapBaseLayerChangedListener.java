package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapBaseLayerChangedListener extends EventListener {

	class MapBaseLayerChangedEvent extends MapLayerEvent {

		public MapBaseLayerChangedEvent(JSObject eventObject) {
			super(eventObject);
		}

	}

	public void onBaseLayerChanged(MapBaseLayerChangedEvent eventObject);
}
