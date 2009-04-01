package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * @author Amr Alam - Refractions Research
 *
 */
public class TMSImpl {

	public static native JSObject create(String name, String url, JSObject options)/*-{
		return new $wnd.OpenLayers.Layer.TMS(name, url, options);
	}-*/;

	public static native int getNumLoadingTiles(JSObject layer)/*-{
		return layer.numLoadingTiles;
	}-*/;
}
