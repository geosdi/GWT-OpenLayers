package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface ControlDeactivateListener extends EventListener {

	class ControlDeactivateEvent extends ControlEvent {
		public ControlDeactivateEvent(JSObject eventObject){
			super(eventObject);
		}
	}

	void onDeactivate(ControlDeactivateEvent eventObject);
}
