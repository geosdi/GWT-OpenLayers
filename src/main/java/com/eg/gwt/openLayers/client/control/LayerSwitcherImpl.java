package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 *
 * @author Erdem Gunay
 *
 */
class LayerSwitcherImpl {

	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.LayerSwitcher();
	}-*/;

	public static native JSObject create(JSObject options)/*-{
		return new $wnd.OpenLayers.Control.LayerSwitcher(options);
	}-*/;

}
