package org.gwtopenmaps.openlayers.client.event;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface ControlActivateListener extends EventListener {

	class ControlActivateEvent extends ControlEvent {
		public ControlActivateEvent(EventObject eventObject){
			super(eventObject.getJSObject());
		}
	}

	void onActivate(ControlActivateEvent eventObject);
}
