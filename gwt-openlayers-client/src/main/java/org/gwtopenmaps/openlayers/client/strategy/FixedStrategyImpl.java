package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class FixedStrategyImpl {
	public native static JSObject create() /*-{
		return new $wnd.OpenLayers.Strategy.Fixed();
	}-*/;
	
	public native static void preload(JSObject self, boolean load) /*-{
		self.preload(load);
	}-*/;

	public native static void destroy(JSObject self) /*-{
		self.destroy();
	}-*/;
}