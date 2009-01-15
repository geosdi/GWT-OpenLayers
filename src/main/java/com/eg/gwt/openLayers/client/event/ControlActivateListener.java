package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.control.Control;

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
