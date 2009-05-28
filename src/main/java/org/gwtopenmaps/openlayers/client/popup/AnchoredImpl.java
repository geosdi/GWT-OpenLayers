package org.gwtopenmaps.openlayers.client.popup;

import org.gwtopenmaps.openlayers.client.util.JSObject;

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
