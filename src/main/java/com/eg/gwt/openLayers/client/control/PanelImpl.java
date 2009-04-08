package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * 
 * @author Curtis Jensen
 *
 */
class PanelImpl {

	public static native JSObject create(JSObject options) /*-{
		return new $wnd.OpenLayers.Control.MouseDefaults(options);
	}-*/;
	
	public static native void addControls(JSObject panel, JSObject controls) /*-{
		panel.addControls(controls);
	}-*/;
}
