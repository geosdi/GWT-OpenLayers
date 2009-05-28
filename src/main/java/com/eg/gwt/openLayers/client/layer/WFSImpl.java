package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * See {@link WFS}
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class WFSImpl {

	public static native JSObject create(String name, String url, JSObject params, JSObject options)/*-{
		return new $wnd.OpenLayers.Layer.WFS(name, url, params, options);
	}-*/;

}
