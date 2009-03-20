package com.eg.gwt.openLayers.client.popup;

import com.eg.gwt.openLayers.client.LonLat;
import com.eg.gwt.openLayers.client.OpenLayersObjectWrapper;
import com.eg.gwt.openLayers.client.Size;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * 
 * @author Erdem Gunay
 *
 */
public class Anchored extends Popup {

	protected Anchored(JSObject element) {
		super(element);
	}

	public Anchored(String id, LonLat lonlat, Size size, String html, OpenLayersObjectWrapper anchor, boolean closeBox) {
		this(AnchoredImpl.create(id, 
				lonlat.getJSObject(),
				size.getJSObject(),
				html,
				anchor.getJSObject(), 
				closeBox));
	}
	
}
