package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * 
 * @author Erdem Gunay
 *	   Amr Alam - Refractions Research 
 *
 */
class LayerImpl {
	public static native void redraw(JSObject layer) /*-{
		layer.redraw();
	}-*/;
	
	public static native void setIsBaseLayer(boolean bool, JSObject layer) /*-{
		layer.setIsBaseLayer(bool);
	}-*/;
	
	public static native boolean isBaseLayer(JSObject layer) /*-{
		return layer.isBaseLayer;
	}-*/;

	public static native String getId(JSObject layer) /*-{
		return layer.id;
	}-*/;
}
