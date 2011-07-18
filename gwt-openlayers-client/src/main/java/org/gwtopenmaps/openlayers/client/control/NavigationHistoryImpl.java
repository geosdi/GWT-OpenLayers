package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * 
 * @author giuseppe
 *
 */
public class NavigationHistoryImpl {
	
	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.NavigationHistory();
	}-*/;

	public static native JSObject create(JSObject options)/*-{
		return new $wnd.OpenLayers.Control.NavigationHistory(options);
	}-*/;
	
	public static native JSObject getPrevious(JSObject self)/*-{
		return self.previous;
	}-*/;
	
	public static native JSObject getNext(JSObject self)/*-{
		return self.next;
	}-*/;
	
	public static native void nextTrigger(JSObject self)/*-{
		self.nextTrigger();
	}-*/;
	
	public static native void previousTrigger(JSObject self)/*-{
		self.previousTrigger();
	}-*/;
	
	public static native void clear(JSObject self)/*-{
		self.clear();
	}-*/;

}
