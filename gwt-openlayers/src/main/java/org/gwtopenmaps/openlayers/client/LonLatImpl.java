package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;

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

	public static native void transform(JSObject self, String src, String dst)/*-{
		self.transform(new $wnd.OpenLayers.Projection(src), new $wnd.OpenLayers.Projection(dst));
	}-*/;

}
