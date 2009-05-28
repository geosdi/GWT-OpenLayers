package com.eg.gwt.openLayers.client.popup;

import com.eg.gwt.openLayers.client.util.JSObject;

public class FramedImpl {

	public static native JSObject create(String id, JSObject lonlat, JSObject size, String html, JSObject anchor, boolean closeBox) /*-{
		var framed = new $wnd.OpenLayers.Popup.Framed(id, lonlat, size, html, anchor, closeBox);
		
		if (size == null)
		  anchored.autoSize = true;
		  
		return framed;
	}-*/;
	
}
