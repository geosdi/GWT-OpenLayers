package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * 
 * @author Erdem Gunay
 * @author Michel Vitor - Intec
 */
class MarkerImpl {

	public static native JSObject create(JSObject lonlat)/*-{
		return new $wnd.OpenLayers.Marker(lonlat);
	}-*/;
	public static native void setIcon(JSObject self,JSObject icon)/*-{
	     self.setIcon(icon);
    }-*/;
	public static native JSObject setLonLat(JSObject lonlat)/*-{
        self.setLonlat(lonlat);
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
