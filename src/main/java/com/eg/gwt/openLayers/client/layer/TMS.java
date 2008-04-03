package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * @author Amr Alam - Refractions Research
 *
 */
public class TMS extends Layer {
   
	protected TMS(JSObject element) {
		super(element);
	}

	public TMS(String name, String url, TMSParams params) {
		this(TMSImpl.create(name, url, params.getJSObject()));
	}
    
	public int getNumLoadingTiles(){
		return TMSImpl.getNumLoadingTiles(this.getJSObject());
	}
}
