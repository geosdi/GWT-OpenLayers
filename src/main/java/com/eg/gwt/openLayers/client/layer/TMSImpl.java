package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * @author Amr Alam - Refractions Research
 *
 */
public class TMSImpl {

	public static native JSObject create(String name, String url, JSObject params)/*-{
		return new $wnd.OpenLayers.Layer.TMS(name, url, params);
	}-*/;

	public static native int getNumLoadingTiles(JSObject layer)/*-{
		return layer.numLoadingTiles;
	}-*/;
}
