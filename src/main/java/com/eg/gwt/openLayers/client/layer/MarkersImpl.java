package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * 
 * @author Erdem Gunay
 *
 */
class MarkersImpl {

	public static native JSObject create(String name)/*-{
		return new $wnd.OpenLayers.Layer.Markers(name);
	}-*/;

	public static native void addMarker(JSObject markers, JSObject marker)/*-{
			var lonlat = new $wnd.OpenLayers.LonLat(37.38,37.06);
			var size = new $wnd.OpenLayers.Size(10,17);
			var offset = new $wnd.OpenLayers.Pixel(-(size.w/2), -size.h);
			var icon = new $wnd.OpenLayers.Icon('img/marker.png',size,offset);
			markers.addMarker(new $wnd.OpenLayers.Marker(lonlat,icon));
			markers.addMarker(marker);
	}-*/;

}
