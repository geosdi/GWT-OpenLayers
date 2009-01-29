package com.eg.gwt.openLayers.client.format;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class WKTImpl {

	public static native JSObject create()
	/*-{
		return new $wnd.OpenLayers.Format.WKT();
	}-*/;

}
