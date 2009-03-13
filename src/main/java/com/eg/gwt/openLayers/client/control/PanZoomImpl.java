package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * See {@link PanZoom}.
 *
 * @author Edwin Commandeur
 * @since GWT-OL 0.4, OL ...
 *
 */
class PanZoomImpl {

	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.PanZoom();
	}-*/;

}
