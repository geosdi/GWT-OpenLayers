package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.util.JSObject;

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
	
	public static native JSObject create(String name, String url, JSObject params, JSObject layerParams)/*-{
		return new $wnd.OpenLayers.Layer.WMS(name, url, params, layerParams);
	}-*/;
	
	public static native int getNumLoadingTiles(JSObject layer)/*-{
		return layer.numLoadingTiles;
	}-*/;
}
