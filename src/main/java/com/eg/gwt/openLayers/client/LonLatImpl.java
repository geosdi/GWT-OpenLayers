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
	
}
