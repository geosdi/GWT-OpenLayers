package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Erdem Gunay
 * @author Wayne Fang - Refractions Research
 * @author Edwin Commandeur - Atlis EJS
 *
 *
 */
class EventsImpl {

	public native static JSObject register(JSObject self, String type, JSObject obj, JSObject handler) /*-{
		self.register(type, obj, handler);
	}-*/;
	public native static JSObject on(JSObject self,JSObject object ) /*-{
	    self.on(object);
    }-*/;
	public native static void unregister(JSObject self, String type, JSObject obj, JSObject handler)/*-{
	   self.unregister(type, obj, handler);
	}-*/;

	public native static JSObject getMousePosition(JSObject self, JSObject evt)/*-{
		return self.getMousePosition(evt);
	}-*/;
	
	public native static JSObject stop(JSObject evt, boolean allowDefault)/*-{
		$wnd.OpenLayers.Event.stop(evt, allowDefault);
	}-*/;
	
}
