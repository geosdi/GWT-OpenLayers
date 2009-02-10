package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;
import com.google.gwt.user.client.Element;

/**
 * 
 * @author Erdem Gunay
 *
 */
class ScaleImpl {

	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.Scale();
	}-*/;
	
	public static native JSObject create(Element div)/*-{
		return new $wnd.OpenLayers.Control.Scale(div);
	}-*/;
}
