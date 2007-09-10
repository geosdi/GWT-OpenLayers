package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JBoolean;
import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.OpenLayersWidget;

/**
 * 
 * @author Erdem Gunay
 *
 */
public abstract class Layer extends OpenLayersWidget {

	protected Layer(JSObject element) {
		super(element);
	}

	public void redraw() {
		LayerImpl.redraw(getJSObject());
	}
}
