package com.eg.gwt.openLayers.client.popup;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * 
 * @author Erdem Gunay
 *
 */
class PopupImpl {
	
	public static native JSObject create(String id, JSObject lonlat, JSObject size, String html, boolean closeBox) /*-{
		return new $wnd.OpenLayers.Popup(id, lonlat, size, html, closeBox);
	}-*/;

}
