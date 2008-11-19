package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * 
 * @author Erdem Gunay
 * 	   Wayne Fang - Refractions Research
 *
 */
class EventsImpl {
 
	public native static void register(JSObject self, String type, JSObject obj, EventHandler handler)/*-{
    	self.register(type, obj,  
			function(eo)
			{
		    	@com.eg.gwt.openLayers.client.ElementBridge::onHandle(Lcom/eg/gwt/openLayers/client/JSObject;Lcom/eg/gwt/openLayers/client/JSObject;Lcom/eg/gwt/openLayers/client/event/EventHandler;)(obj, eo, handler);
			}
		);
	}-*/;
	
	public native static void unregister(JSObject self, String type, JSObject obj)/*-{
		self.unregister(type, obj);
	}-*/;
	
	public native static JSObject getMousePosition(JSObject self, JSObject evt)/*-{
		return self.getMousePosition(evt);
	}-*/;
}
