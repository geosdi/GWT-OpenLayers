package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * 
 * @author Curtis Jensen
 *
 */
class MouseDefaultsImpl {

	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.MouseDefaults();
	}-*/;
	
	public static native JSObject create(JSObject options) /*-{
    	return new $wnd.OpenLayers.Control.MouseDefaults(options);
 	}-*/;	
}
