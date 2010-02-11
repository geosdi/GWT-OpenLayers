package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JStringArray;

/**
 *
 * @author Erdem Gunay
 * 	       Amr Alam - Refractions Research
 *         Curtis Jensen
 */
public class WMS extends Layer {

	protected WMS(JSObject wms) {
		super(wms);
	}

	public static WMS narrowToWMS(JSObject wms){
		return (wms == null)?null: new WMS(wms);
	}
	
	public WMS(String name, String url, WMSParams params) {
		this(WMSImpl.create(name, url, params.getJSObject()));
	}

	public WMS(String name, String url, WMSParams params, WMSOptions layerParams) {
		this(WMSImpl.create(name, url, params.getJSObject(), layerParams.getJSObject()));
	}

	public WMS(String name, String[] urls, WMSParams params) {
		this(WMSImpl.create(name, new JStringArray(urls).getJSObject(), params.getJSObject()));
	}

	public WMS(String name, String[] urls, WMSParams params, WMSOptions layerParams) {
		this(WMSImpl.create(name, new JStringArray(urls).getJSObject(), params.getJSObject(), layerParams.getJSObject()));
	}

	public int getNumLoadingTiles(){
		return WMSImpl.getNumLoadingTiles(this.getJSObject());
	}

}
