package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * 
 * @author Erdem Gunay
 * 	   Amr Alam - Refractions Research
 *
 */
class WMSImpl {

	public static native JSObject create(String name, String url, JSObject params)/*-{
		return new $wnd.OpenLayers.Layer.WMS(name, url, params);
	}-*/;
	
	public static native JSObject create(String name, String url, JSObject params, JSObject options)/*-{
		return new $wnd.OpenLayers.Layer.WMS(name, url, params, options);
	}-*/;
	
	public static native int getNumLoadingTiles(JSObject layer)/*-{
		return layer.numLoadingTiles;
	}-*/;
}
