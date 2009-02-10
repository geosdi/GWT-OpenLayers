package com.eg.gwt.openLayers.client;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * 
 * @author Erdem Gunay
 *
 */
class PixelImpl {

	public static native JSObject create(int x, int y)/*-{
		return new $wnd.OpenLayers.Pixel(x, y);
	}-*/;
	
	public static native String toString(JSObject self)/*-{
		return self.toString();
	}-*/;
}
