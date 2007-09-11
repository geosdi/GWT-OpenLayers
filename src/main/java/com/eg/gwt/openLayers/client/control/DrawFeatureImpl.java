package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.JSObject;
import com.google.gwt.user.client.Element;

/**
 * 
 * @author Erdem Gunay
 *
 */
class DrawFeatureImpl {

	public static native JSObject create(JSObject layer, JSObject handler)/*-{
		return new $wnd.OpenLayers.Control.DrawFeature(layer, handler);
	}-*/;
	
	public static native JSObject create(JSObject layer, JSObject handler, JSObject options)/*-{
		return new $wnd.OpenLayers.Control.DrawFeature(layer, handler, options);
	}-*/;
	
}
