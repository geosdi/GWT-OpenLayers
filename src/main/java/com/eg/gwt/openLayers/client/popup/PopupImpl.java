package com.eg.gwt.openLayers.client.popup;

import com.eg.gwt.openLayers.client.popup.Popup.CloseListener;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * 
 * @author Erdem Gunay
 * @author Curtis Jensen
 *
 */
class PopupImpl {
	
	public static native JSObject create(String id, JSObject lonlat, JSObject size, String html, boolean closeBox) /*-{
		return new $wnd.OpenLayers.Popup(id, lonlat, size, html, closeBox);
	}-*/;

	public static native void addCloseBox(JSObject popup, CloseListener callback) /*-{
    	function closebox(evt) {
    		callback.@com.eg.gwt.openLayers.client.popup.Popup.CloseListener::onPopupClose(Lcom/eg/gwt/openLayers/client/util/JSObject;)(evt);
    	}
    
		popup.addCloseBox(closebox);
	}-*/;
}
