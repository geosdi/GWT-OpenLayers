package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface LayerLoadCancelListener extends EventListener {

	class LoadCancelEvent extends LayerEvent{

		public LoadCancelEvent(JSObject eventObject) {
			super(eventObject);
		}

	}

	public void onLoadCancel(LoadCancelEvent eventObject);
}
