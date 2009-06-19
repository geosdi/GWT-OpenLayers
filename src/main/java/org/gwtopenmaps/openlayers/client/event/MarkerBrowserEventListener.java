package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MarkerBrowserEventListener extends EventListener {

	class MarkerBrowserEvent extends MarkerEvent {

		public MarkerBrowserEvent(JSObject eventObject) {
			super(eventObject);
		}

	}

	public void onBrowserEvent(MarkerBrowserEvent markerBrowserEvent);
}
