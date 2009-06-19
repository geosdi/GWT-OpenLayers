package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * Listens to 'changelayer' event that fires on:
 *  a name change, an order change, or a visibility change of a layer
 *
 * Listening to visibility changes can be done at the layer level
 * with a LayerVisibilityChangedListener.
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapLayerChangedListener extends EventListener {

	class MapLayerChangedEvent extends MapLayerEvent {

		public MapLayerChangedEvent(JSObject eventObject) {
			super(eventObject);
		}

	}

	public void onLayerChanged(MapLayerChangedEvent eventObject);
}
