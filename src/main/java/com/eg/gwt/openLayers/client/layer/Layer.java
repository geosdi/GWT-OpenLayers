package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.OpenLayersWidget;

/**
 * 
 * @author Erdem Gunay
 *         Amr Alam - Refractions Research
 *
 */
public class Layer extends OpenLayersWidget {

	public Layer(JSObject element) {
		super(element);
	}

	public void redraw() {
		LayerImpl.redraw(getJSObject());
	}
	
	public void setIsBaseLayer(boolean isBaseLayer) {
		LayerImpl.setIsBaseLayer(isBaseLayer, getJSObject());
	}
	
	public boolean isBaseLayer() {
		return LayerImpl.isBaseLayer(getJSObject());
	}
	
	public String getId() {
		return LayerImpl.getId(getJSObject());
	}
	
	public void setOpacity(float opacity){ 
	    	LayerImpl.setOpacity(opacity, getJSObject());
	}
}
