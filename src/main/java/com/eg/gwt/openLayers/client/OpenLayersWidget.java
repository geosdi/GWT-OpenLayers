package com.eg.gwt.openLayers.client;

import com.eg.gwt.openLayers.client.event.Events;

/**
 * 
 * @author Erdem Gunay
 *
 */
public class OpenLayersWidget {

	private JSObject element;

	protected OpenLayersWidget(JSObject element)
	{
		setJSObject(element);
	}
	
	public static OpenLayersWidget narrowToOpenLayersWidget(JSObject element)
	{
		return (element == null)?null: new OpenLayersWidget(element);
	}
	
	public JSObject getJSObject() {
		return element;
	}

	public void setJSObject(JSObject element) {
		this.element = element;
	}

	public Events getEvents() {
		return Events.narrowToEventsWidget(OpenLayersWidgetImpl.getEvents(getJSObject()));
	}
}
