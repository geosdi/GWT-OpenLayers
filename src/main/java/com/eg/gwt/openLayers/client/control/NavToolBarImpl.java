package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * Access the openlayers navtoolbar control.
 * 
 * @author Emily Gouge - Refractions Research
 *
 */
public class NavToolBarImpl {
	
	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.NavToolbar();
	}-*/;

	public static native JSObject create(JSObject options)/*-{
		return new $wnd.OpenLayers.Control.NavToolbar(options);
	}-*/;

}
