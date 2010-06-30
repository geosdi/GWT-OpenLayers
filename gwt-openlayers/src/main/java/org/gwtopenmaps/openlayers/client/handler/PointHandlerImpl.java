package org.gwtopenmaps.openlayers.client.handler;

import org.gwtopenmaps.openlayers.client.util.JSObject;

class PointHandlerImpl {

	public static native JSObject create() /*-{
		return $wnd.OpenLayers.Handler.Point;
	}-*/;

}