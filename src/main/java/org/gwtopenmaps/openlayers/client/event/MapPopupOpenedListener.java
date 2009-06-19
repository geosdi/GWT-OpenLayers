package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapPopupOpenedListener extends EventListener {

	class MapPopupOpenedEvent extends MapEvent {

		public MapPopupOpenedEvent(JSObject eventObject) {
			super(eventObject);
		}

		//getPopup ???
	}

	public void onPopupOpened(MapPopupOpenedEvent eventObject);
}
