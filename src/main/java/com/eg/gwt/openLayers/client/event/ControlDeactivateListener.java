package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.control.Control;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface ControlDeactivateListener extends EventListener {

	class ControlDeactivateEvent extends EventObject {
		public ControlDeactivateEvent(JSObject eventObject){
			super(eventObject);
		}
	}

	void onDeactivate(Control source, ControlDeactivateEvent eventObject);
}
