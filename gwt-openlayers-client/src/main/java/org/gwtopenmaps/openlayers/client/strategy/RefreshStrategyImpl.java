package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class RefreshStrategyImpl {

	public native static JSObject create() /*-{
		return $wnd.OpenLayers.Strategy.Refresh();
	}-*/;

	public native static boolean activate(JSObject self) /*-{
		return self.activate();
	}-*/;

	public native static boolean deactivate(JSObject self) /*-{
		return self.deactivate();
	}-*/;

	public native static void refresh(JSObject self) /*-{
		self.refresh();
	}-*/;
}
