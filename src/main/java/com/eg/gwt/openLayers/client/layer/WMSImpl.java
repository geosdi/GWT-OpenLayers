package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * 
 * @author Erdem Gunay
 *
 */
class WMSImpl {

	public static native JSObject create(String name, String url, JSObject params)/*-{
		return new $wnd.OpenLayers.Layer.WMS(name, url, params);
	}-*/;
	
}
