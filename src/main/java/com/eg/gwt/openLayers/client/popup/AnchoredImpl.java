package com.eg.gwt.openLayers.client.popup;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * 
 * @author Erdem Gunay
 *
 */
class AnchoredImpl {
	
	public static native JSObject create(String id, JSObject lonlat, JSObject size, String html, JSObject anchor, boolean closeBox) /*-{
		return new $wnd.OpenLayers.Popup.Anchored(id, lonlat, size, html, anchor, closeBox);
	}-*/;

}
