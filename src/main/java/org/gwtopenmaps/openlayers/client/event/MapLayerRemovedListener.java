package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapLayerRemovedListener extends EventListener {

	class MapLayerRemovedEvent extends MapLayerEvent {

		public MapLayerRemovedEvent(JSObject eventObject) {
			super(eventObject);
		}

	}

	public void onLayerRemoved(MapLayerRemovedEvent eventObject);
}
