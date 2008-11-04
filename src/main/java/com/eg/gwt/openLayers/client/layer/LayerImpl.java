package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * 
 * @author Erdem Gunay
 *         Amr Alam - Refractions Research 
 *         Edwin Commandeur - Atlis EJS
 *
 */
class LayerImpl {
	public static native void redraw(JSObject layer) /*-{
		layer.redraw();
	}-*/;
	
	public static native void setIsBaseLayer(boolean isBaseLayer, JSObject layer) /*-{
		layer.setIsBaseLayer(isBaseLayer);
	}-*/;
	
	public static native boolean isBaseLayer(JSObject layer) /*-{
		return layer.isBaseLayer;
	}-*/;

	public static native String getId(JSObject layer) /*-{
		return layer.id;
	}-*/;
	
	public static native void setOpacity(float opacity, JSObject layer) /*-{
		layer.setOpacity(opacity);
	}-*/;
	
	public static native boolean displayInLayerSwitcher(JSObject layer) /*-{
       return layer.displayInLayerSwitcher;
    }-*/;

	public static native void setDisplayInLayerSwitcher(boolean display, JSObject layer)/*-{
       layer.displayInLayerSwitcher = display;
    }-*/;
}
