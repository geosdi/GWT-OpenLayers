package org.gwtopenmaps.openlayers.client.popup;

import org.gwtopenmaps.openlayers.client.popup.Popup.CloseListener;
import org.gwtopenmaps.openlayers.client.util.JSObject;

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
			callback.@org.gwtopenmaps.openLayers.client.popup.Popup.CloseListener::onPopupClose(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(evt);
		}

		popup.addCloseBox(closebox);
	}-*/;
}
