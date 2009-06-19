package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface LayerLoadEndListener extends EventListener {

	class LoadEndEvent extends LayerEvent {

		public LoadEndEvent(JSObject eventObject) {
			super(eventObject);
		}

	}

	public void onLoadEnd(LoadEndEvent eventObject);
}
