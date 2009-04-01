package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.util.JSObject;
import com.eg.gwt.openLayers.client.util.JStringArray;
import com.eg.gwt.openLayers.client.util.Options;

/**
 *
 * @author Erdem Gunay
 * 	       Amr Alam - Refractions Research
 *         Curtis Jensen
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

	public WMS(String name, String url, WMSParams params, WMSOptions layerParams) {
	        this(WMSImpl.create(name, url, params.getJSObject(), layerParams.getJSObject()));
	}

	public WMS(String name, String[] urls, WMSParams params) {
		this(WMSImpl.create(name, new JStringArray(urls).getJSObject(), params.getJSObject()));
	}

	public WMS(String name, String[] urls, WMSParams params, Options options) {
		this(WMSImpl.create(name, new JStringArray(urls).getJSObject(), params.getJSObject(), options.getJSObject()));
	}

	public WMS(String name, String[] urls, WMSParams params, WMSOptions layerParams) {
	        this(WMSImpl.create(name, new JStringArray(urls).getJSObject(), params.getJSObject(), layerParams.getJSObject()));
	}
	
	public int getNumLoadingTiles(){
		return WMSImpl.getNumLoadingTiles(this.getJSObject());
	}

}
