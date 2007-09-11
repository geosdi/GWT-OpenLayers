package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * 
 * @author Erdem Gunay
 *
 */
class MousePositionImpl {

	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.MousePosition();
	}-*/;
	
	public static native JSObject create(JSObject options)/*-{
		return new $wnd.OpenLayers.Control.MousePosition(options);
	}-*/;

}
