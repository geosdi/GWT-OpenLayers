package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JBoolean;
import com.eg.gwt.openLayers.client.JSObject;

/**
 * 
 * @author Erdem Gunay
 *
 */
class LayerImpl {
	public static native void redraw(JSObject layer) /*-{
		layer.redraw();
	}-*/;
}
