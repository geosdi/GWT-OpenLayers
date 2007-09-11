package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.JSObject;
import com.google.gwt.user.client.Element;

/**
 * 
 * @author Erdem Gunay
 *
 */
class PanZoomBarImpl {

	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.PanZoomBar();
	}-*/;
	
	public static native JSObject create(JSObject options)/*-{
		return new $wnd.OpenLayers.Control.PanZoomBar(options);
	}-*/;

}
