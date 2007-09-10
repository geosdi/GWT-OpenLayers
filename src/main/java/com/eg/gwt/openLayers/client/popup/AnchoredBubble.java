package com.eg.gwt.openLayers.client.popup;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.LonLat;
import com.eg.gwt.openLayers.client.OpenLayersWidget;
import com.eg.gwt.openLayers.client.Size;

/**
 * 
 * @author Erdem Gunay
 *
 */
public class AnchoredBubble extends Popup {

	protected AnchoredBubble(JSObject element) {
		super(element);
	}

	public AnchoredBubble(String id, LonLat lonlat, Size size, String html, OpenLayersWidget anchor, boolean closeBox) {
		this(AnchoredBubbleImpl.create(id, 
				lonlat.getJSObject(),
				size.getJSObject(),
				html,
				anchor.getJSObject(), 
				closeBox));
	}
	
}
