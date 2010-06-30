package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.OpenLayersEObjectWrapper;
import org.gwtopenmaps.openlayers.client.event.ControlActivateListener;
import org.gwtopenmaps.openlayers.client.event.ControlDeactivateListener;
import org.gwtopenmaps.openlayers.client.event.EventHandler;
import org.gwtopenmaps.openlayers.client.event.EventObject;
import org.gwtopenmaps.openlayers.client.event.EventType;
import org.gwtopenmaps.openlayers.client.event.ControlActivateListener.ControlActivateEvent;
import org.gwtopenmaps.openlayers.client.event.ControlDeactivateListener.ControlDeactivateEvent;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Erdem Gunay
 *
 */
public class Control extends OpenLayersEObjectWrapper {

	protected Control(JSObject element) {
		super(element);
	}

	public static Control narrowToControl(JSObject object){
		return new Control(object);
	}

	public boolean activate() {
		return ControlImpl.activate(getJSObject());
	}

	public boolean deactivate() {
		return ControlImpl.deactivate(getJSObject());
	}

	public void addControlActivateListener(final ControlActivateListener listener){
		eventListeners.addListener(this, listener, EventType.CONTROL_ACTIVATE, new EventHandler(){
			public void onHandle(EventObject eventObject) {
				ControlActivateEvent e = new ControlActivateEvent(eventObject);
				listener.onActivate(e);
			}
		 });
	};

	public void addControlDeactivateListener(final ControlDeactivateListener listener){
		eventListeners.addListener(this, listener, EventType.CONTROL_DEACTIVATE, new EventHandler(){
			public void onHandle(EventObject eventObject) {
				ControlDeactivateEvent e = new ControlDeactivateEvent(eventObject);
				listener.onDeactivate(e);
			}
		 });
	};
	
	/**
	 * get the map to which this control is attached
	 *
	 * @return the map
	 */
	public Map getMap() {
		return Map.narrowToMap(this.getJSObject().getProperty("map"));
	}
	
}
