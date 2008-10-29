package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.Options;

/**
 * 
 * @author Erdem Gunay
 * 	   Amr Alam - Refractions Research
 *
 */
public class WMS extends Layer {

	protected WMS(JSObject element) {
		super(element);
	}
	
	public WMS(String name, String url, WMSParams params) {
		this(WMSImpl.create(name, url, params.getJSObject()));
	}
	
	public WMS(String name, String url, WMSParams params, Options options) {
		this(WMSImpl.create(name, url, params.getJSObject(), options.getJSObject()));
	}

	public WMS(String name, String url, WMSParams params, WMSExtraParams extraParams) {
	        this(WMSImpl.create(name, url, params.getJSObject(), extraParams.getJSObject()));
	}
	
	public int getNumLoadingTiles(){
		return WMSImpl.getNumLoadingTiles(this.getJSObject());
	}

}
