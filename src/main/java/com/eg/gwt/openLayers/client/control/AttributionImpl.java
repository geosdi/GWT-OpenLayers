package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * See {@link Attribution}.
 *
 * @author Edwin Commandeur
 *
 */
class AttributionImpl {

	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.Attribution();
	}-*/;

}
