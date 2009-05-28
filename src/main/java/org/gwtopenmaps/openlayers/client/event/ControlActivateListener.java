package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.control.Control;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface ControlActivateListener extends EventListener {

	class ControlActivateEvent extends EventObject {
		public ControlActivateEvent(JSObject eventObject){
			super(eventObject);
		}
	}

	void onActivate(Control source, ControlActivateEvent eventObject);
}
