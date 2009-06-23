package org.gwtopenmaps.openlayers.client.popup;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Edwin Commandeur - Atlis Information Systems
 *
 */
public class FramedCloudImpl {

	public static native JSObject create(String id, JSObject lonlat, JSObject size, String html, JSObject anchor, boolean closeBox) /*-{
		var framedCloud = new $wnd.OpenLayers.Popup.FramedCloud(id, lonlat, size, html, anchor, closeBox);
		//if (size == null)
		//  anchored.autoSize = true;
		return framedCloud;
	}-*/;

}
