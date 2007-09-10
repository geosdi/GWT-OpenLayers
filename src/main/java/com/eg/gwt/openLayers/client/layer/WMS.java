package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * 
 * @author Erdem Gunay
 *
 */
public class WMS extends Layer {

	protected WMS(JSObject element) {
		super(element);
	}
	
	public WMS(String name, String url, WMSParams params) {
		this(WMSImpl.create(name, url, params.getJSObject()));
	}

}
