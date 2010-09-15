package org.gwtopenmaps.openlayers.client.event;

/**
 * Needs to be implemented to listen to map moveend events.
 *
 * @author Lukas Johansson
 *
 */
public interface MapMoveEndListener extends EventListener {

	class MapMoveEndEvent extends MapEvent {
		public MapMoveEndEvent(EventObject eventObject) {
			super(eventObject.getJSObject());
		}
	}

	void onMapMoveEnd(MapMoveEndEvent eventObject);

}