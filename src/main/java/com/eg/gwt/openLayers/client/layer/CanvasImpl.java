package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * 
 * @author Erdem Gunay
 *
 */
class CanvasImpl {

	public static native JSObject create(String name)/*-{
		return new $wnd.OpenLayers.Layer.Canvas(name);
	}-*/;
	
	public static native void drawLine(JSObject self, JSObject p1, JSObject p2)/*-{
		self.drawLine(p1, p2);
	}-*/;
}
