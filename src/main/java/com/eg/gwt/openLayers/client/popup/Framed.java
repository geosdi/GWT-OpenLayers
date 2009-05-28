package com.eg.gwt.openLayers.client.popup;

import com.eg.gwt.openLayers.client.util.JSObject;
import com.eg.gwt.openLayers.client.LonLat;
import com.eg.gwt.openLayers.client.OpenLayersObjectWrapper;
import com.eg.gwt.openLayers.client.Size;

/**
 * 
 * @author Curtis Jensen
 *
 */
public class Framed extends Popup {

	protected Framed(JSObject element) {
		super(element);
	}

	public Framed(String id, LonLat lonlat, Size size, String html, OpenLayersObjectWrapper anchor, boolean closeBox) {
		this(FramedImpl.create(id, 
				lonlat.getJSObject(),
				size.getJSObject(),
				html,
				anchor.getJSObject(), 
				closeBox));
	}
	
	public Framed(String id, LonLat lonlat, Size size, String html, boolean closeBox) {
		this(FramedImpl.create(id, 
				lonlat.getJSObject(),
				size.getJSObject(),
				html,
				null, 
				closeBox));
	}
	
	public Framed(String id, LonLat lonlat, String html, boolean closeBox) {
		this(FramedImpl.create(id, 
				lonlat.getJSObject(),
				null,
				html,
				null, 
				closeBox));
	}
}
