package com.eg.gwt.openLayers.client.popup;

import com.eg.gwt.openLayers.client.LonLat;
import com.eg.gwt.openLayers.client.OpenLayersWidget;
import com.eg.gwt.openLayers.client.Size;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * 
 * @author Erdem Gunay
 *
 */
public class Popup extends OpenLayersWidget {

	protected Popup(JSObject element) {
		super(element);
	}

	public Popup(String id, LonLat lonlat, Size size, String html, boolean closeBox) {
		this(PopupImpl.create(id, 
				lonlat.getJSObject(),
				size.getJSObject(),
				html,
				closeBox));
	}
}
