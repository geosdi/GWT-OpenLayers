package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.OpenLayersWidget;
import com.eg.gwt.openLayers.client.Pixel;

/**
 * 
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class Events extends OpenLayersWidget {

	protected Events(JSObject element) {
		super(element);
	}

	public static Events narrowToEventsWidget(JSObject element)
	{
		return (element == null)?null: new Events(element);
	}
	
	public void register(String type, OpenLayersWidget obj, EventHandler handler)
	{
		EventsImpl.register(getJSObject(), type, obj.getJSObject(), handler.getJSObject());
	}
	
	public void unregister(String type, OpenLayersWidget obj, EventHandler handler)
	{
	    EventsImpl.unregister(getJSObject(), type, obj.getJSObject(), handler.getJSObject());
	}
	
	public Pixel getMousePosition(Event e) 
	{
		return Pixel.narrowToMap(EventsImpl.getMousePosition(getJSObject(), e.getJSObject()));
	}
}
