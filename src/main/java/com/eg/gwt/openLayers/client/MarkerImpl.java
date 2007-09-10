package com.eg.gwt.openLayers.client;


/**
 * 
 * @author Erdem Gunay
 *
 */
class MarkerImpl {

	public static native JSObject create(JSObject lonlat)/*-{
		return new $wnd.OpenLayers.Marker(lonlat);
	}-*/;
	
	public static native JSObject create(JSObject lonlat, JSObject icon)/*-{
		return new $wnd.OpenLayers.Marker(lonlat, icon);
	}-*/;

	public static native JSObject getLonLat(JSObject self)/*-{
		return self.lonlat;
	}-*/;

	public static native JSObject getIcon(JSObject self)/*-{
		return self.icon;
	}-*/;
}
