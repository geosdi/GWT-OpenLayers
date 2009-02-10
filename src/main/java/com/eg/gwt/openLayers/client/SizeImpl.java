package com.eg.gwt.openLayers.client;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * 
 * @author Erdem Gunay
 *
 */
class SizeImpl {

	public static native JSObject create(int w, int h)/*-{
		return new $wnd.OpenLayers.Size(w, h);
	}-*/;
	
}
