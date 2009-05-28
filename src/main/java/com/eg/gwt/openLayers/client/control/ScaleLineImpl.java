package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class ScaleLineImpl {

	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.ScaleLine();
	}-*/;

	public static native JSObject create(JSObject options)/*-{
		return new $wnd.OpenLayers.Control.ScaleLine(options);
	}-*/;
}
