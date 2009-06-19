package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface LayerVisibilityChangedListener extends EventListener {

	class VisibilityChangedEvent extends LayerEvent {

		public VisibilityChangedEvent(JSObject eventObject) {
			super(eventObject);
		}

	}

	public void onVisibilityChanged(VisibilityChangedEvent eventObject);
}
