package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * 
 * @author Erdem Gunay
 * 	   Wayne Fang - Refractions Research
 *
 */
class MarkersImpl {

	public static native JSObject create(String name)/*-{
		return new $wnd.OpenLayers.Layer.Markers(name);
	}-*/;

	public static native void addMarker(JSObject markers, JSObject marker)/*-{
		markers.addMarker(marker);
	}-*/;
	
	public static native void removeMarker(JSObject markers, JSObject marker)/*-{
		markers.removeMarker(marker);
	}-*/;
	
	public static native void destroy(JSObject markers)/*-{
		markers.destroy();
	}-*/;
}
