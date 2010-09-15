package org.gwtopenmaps.openlayers.client.event;

/**
 *
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapMarkerAddedListener extends EventListener {

	class MapMarkerAddedEvent extends MapEvent {

		public MapMarkerAddedEvent(EventObject eventObject) {
			super(eventObject.getJSObject());
		}

		//getMarker ???
	}

	public void onMarkerAdded(MapMarkerAddedEvent eventObject);
}
