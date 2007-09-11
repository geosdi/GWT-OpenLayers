package com.eg.gwt.openLayers.client;

/**
 * 
 * @author Erdem Gunay
 *
 */
class LonLatImpl {

	public static native JSObject create(double lon, double lat)/*-{
    	return new $wnd.OpenLayers.LonLat(lon, lat);
    }-*/;
	
	public static native double lon(JSObject self)/*-{
		return self.lon;
	}-*/;
	
	public static native double lat(JSObject self)/*-{
		return self.lat;
	}-*/;
	
}
