package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.OpenLayersWidget;
import com.eg.gwt.openLayers.client.event.ControlActivateListener;
import com.eg.gwt.openLayers.client.event.ControlDeactivateListener;
import com.eg.gwt.openLayers.client.event.ControlDeactivateListener.ControlDeactivateEvent;
import com.eg.gwt.openLayers.client.event.EventHandler;
import com.eg.gwt.openLayers.client.event.EventListener;
import com.eg.gwt.openLayers.client.event.EventListenerCollection;
import com.eg.gwt.openLayers.client.event.EventType;
import com.eg.gwt.openLayers.client.event.ControlActivateListener.ControlActivateEvent;

/**
 *
 * @author Erdem Gunay
 *
 */
public class Control extends OpenLayersWidget {

	protected EventListenerCollection eventListeners = new EventListenerCollection();

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

	public void AddControlActivateListener(final ControlActivateListener listener){
		eventListeners.addListener(this, listener, EventType.CONTROL_ACTIVATE, new EventHandler(){
			public void onHandle(JSObject source, JSObject eventObject) {
				Control control = Control.narrowToControl(source);
				ControlActivateEvent e = new ControlActivateEvent(eventObject);
				listener.onActivate(control, e);
			}
		 });
	};

	public void AddControlDeactivateListener(final ControlDeactivateListener listener){
		eventListeners.addListener(this, listener, EventType.CONTROL_DEACTIVATE, new EventHandler(){
			public void onHandle(JSObject source, JSObject eventObject) {
				Control control = Control.narrowToControl(source);
				ControlDeactivateEvent e = new ControlDeactivateEvent(eventObject);
				listener.onDeactivate(control, e);
			}
		 });
	};

	public void removeListener(EventListener listener){
		eventListeners.removeListener(this, listener);
	};

}
