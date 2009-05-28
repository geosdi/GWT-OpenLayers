package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 *
 * @author Erdem Gunay
 *
 */
class MouseToolbarImpl {

	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.MouseToolbar();
	}-*/;

	public static native JSObject create(JSObject options)/*-{
		return new $wnd.OpenLayers.Control.MouseToolbar(options);
	}-*/;
}
