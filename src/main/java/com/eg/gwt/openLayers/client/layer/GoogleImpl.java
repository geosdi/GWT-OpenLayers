package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * 
 * @author Erdem Gunay
 *
 */
class GoogleImpl {

	public static native JSObject create(String name)/*-{
		return new $wnd.OpenLayers.Layer.Google(name);
	}-*/;
	
}
