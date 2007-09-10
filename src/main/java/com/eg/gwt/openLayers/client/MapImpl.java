package com.eg.gwt.openLayers.client;

import com.google.gwt.user.client.Element;

/**
 * 
 * @author Erdem Gunay
 *
 */
class MapImpl {
	
	public static native JSObject create(Element div)/*-{
    	return new $wnd.OpenLayers.Map(div);
    }-*/;
	
	public static native JSObject create(Element div, JSObject options)/*-{
		return new $wnd.OpenLayers.Map(div, options);
	}-*/;

	public static native void setCenter(JSObject map, JSObject lonlat)/*-{
		map.setCenter(lonlat);
	}-*/;

	public static native void setCenter(JSObject map, JSObject lonlat, int zoom)/*-{
		map.setCenter(lonlat, zoom);
    }-*/;
	
	public static native void addControl(JSObject map, JSObject control)/*-{
		map.addControl(control);
    }-*/;
	
	public static native void addLayer(JSObject map, JSObject layer)/*-{
		map.addLayer(layer);
	}-*/;

	public static native void addLayers(JSObject map, JSObject layers)/*-{
		map.addLayers(layers);
	}-*/;

	public static native void addPopup(JSObject map, JSObject popup)/*-{
		map.addPopup(popup);
	}-*/;

	public static native void removePopup(JSObject map, JSObject popup)/*-{
		map.removePopup(popup);
	}-*/;
}
