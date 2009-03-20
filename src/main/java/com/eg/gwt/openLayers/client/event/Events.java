package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.OpenLayersObjectWrapper;
import com.eg.gwt.openLayers.client.Pixel;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * 
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class Events extends OpenLayersObjectWrapper {

	protected Events(JSObject element) {
		super(element);
	}

	public static Events narrowToEvents(JSObject element)
	{
		return (element == null)?null: new Events(element);
	}
	
	public void register(String type, OpenLayersObjectWrapper obj, EventHandler handler)
	{
		EventsImpl.register(getJSObject(), type, obj.getJSObject(), handler.getJSObject());
	}
	
	public void unregister(String type, OpenLayersObjectWrapper obj, EventHandler handler)
	{
	    EventsImpl.unregister(getJSObject(), type, obj.getJSObject(), handler.getJSObject());
	}
	
	public Pixel getMousePosition(Event e) 
	{
		return Pixel.narrowToPixel(EventsImpl.getMousePosition(getJSObject(), e.getJSObject()));
	}
}
