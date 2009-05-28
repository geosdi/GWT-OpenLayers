package com.eg.gwt.openLayers.client;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * 
 * @author Erdem Gunay
 * @author Curtis Jensen
 *
 */
class PixelImpl {

	public static native JSObject create(int x, int y)/*-{
		return new $wnd.OpenLayers.Pixel(x, y);
	}-*/;

	public static native int getX(JSObject self)/*-{
		return self.x;
	}-*/;
	
	public static native int getY(JSObject self)/*-{
		return self.y;
	}-*/;
	
	public static native String toString(JSObject self)/*-{
		return self.toString();
	}-*/;
}
