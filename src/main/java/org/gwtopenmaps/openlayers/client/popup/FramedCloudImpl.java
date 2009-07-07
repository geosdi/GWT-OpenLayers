package org.gwtopenmaps.openlayers.client.popup;

import org.gwtopenmaps.openlayers.client.util.JSObject;

import com.google.gwt.dom.client.Element;

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

	public static native Element getContentDiv(JSObject popup)/*-{
		return popup.contentDiv;
	}-*/;
}
