package com.eg.gwt.openLayers.client;

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
