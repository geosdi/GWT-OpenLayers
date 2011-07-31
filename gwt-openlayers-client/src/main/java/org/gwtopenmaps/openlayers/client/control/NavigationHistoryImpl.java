package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * 
 * @author giuseppe
 *
 */
public class NavigationHistoryImpl {
	
	public native static JSObject create() /*-{
		return new $wnd.OpenLayers.Control.NavigationHistory();
	}-*/;	
	
	public static native JSObject create(JSObject options)/*-{
	    return new $wnd.OpenLayers.Control.NavigationHistory(options);
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
	
	public static native JSObject getPrevious(JSObject self)/*-{
		return self.previous;
	}-*/;
	
	public static native JSObject getNext(JSObject self)/*-{
		return self.next;
	}-*/;
	
	public static native void previousTrigger(JSObject self)/*-{
		self.previousTrigger();
	}-*/;
	
	public static native void clear(JSObject self)/*-{
		self.clear();
	}-*/;

}
