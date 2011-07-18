package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class BBoxStrategyImpl {

	public native static JSObject create()/*-{
		return new $wnd.OpenLayers.Strategy.BBOX();
	}-*/;
}
