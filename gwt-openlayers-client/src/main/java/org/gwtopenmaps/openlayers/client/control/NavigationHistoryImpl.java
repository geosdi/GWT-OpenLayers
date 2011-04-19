package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class NavigationHistoryImpl {
	public native static JSObject create() /*-{
		return new $wnd.OpenLayers.Control.NavigationHistory();
	}-*/;
	
	public native static void previous(JSObject self) /*-{
		self.previous.trigger();
	}-*/;
	
	public native static void next(JSObject self) /*-{
		self.next.trigger();
	}-*/;
	
	public native static void limit(JSObject self, int limit) /*-{
		self.limit = limit;
	}-*/;
	
	public native static void autoActivate(JSObject self, boolean autoActivate) /*-{
		self.autoActivate = autoActivate;
	}-*/;
	
	public native static JSObject nextTrigger(JSObject self) /*-{	
		return self.nextTrigger();		
	}-*/;
}