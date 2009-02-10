package com.eg.gwt.openLayers.client;

import com.eg.gwt.openLayers.client.event.Events;
import com.eg.gwt.openLayers.client.util.JSObject;
import com.eg.gwt.openLayers.client.util.JSObjectWrapper;

/**
 *
 * @author Erdem Gunay
 *
 */
public class OpenLayersWidget extends JSObjectWrapper {

	protected OpenLayersWidget(JSObject element)
	{
		super(element);
	}

	public static OpenLayersWidget narrowToOpenLayersWidget(JSObject element)
	{
		return (element == null)?null: new OpenLayersWidget(element);
	}

	public Events getEvents() {
		return Events.narrowToEventsWidget(OpenLayersWidgetImpl.getEvents(getJSObject()));
	}
}
