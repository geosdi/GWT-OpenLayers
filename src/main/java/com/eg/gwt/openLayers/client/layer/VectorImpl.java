package com.eg.gwt.openLayers.client.layer;

import com.eg.gwt.openLayers.client.JBoolean;
import com.eg.gwt.openLayers.client.JSObject;

/**
 * 
 * @author Erdem Gunay
 *
 */
class VectorImpl {

	public static native JSObject create(String name) /*-{
		return new $wnd.OpenLayers.Layer.Vector(name);
	}-*/;

	public static native JSObject create(String name, JSObject options) /*-{
		return new $wnd.OpenLayers.Layer.Vector(name, options);
	}-*/;

}
