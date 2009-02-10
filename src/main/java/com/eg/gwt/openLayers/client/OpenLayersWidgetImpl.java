package com.eg.gwt.openLayers.client;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * 
 * @author Erdem Gunay
 *
 */
class OpenLayersWidgetImpl {

	public static native JSObject getEvents(JSObject self)/*-{
		var events = self.events;
		return (events === undefined) ? null : events;
	}-*/;
}
