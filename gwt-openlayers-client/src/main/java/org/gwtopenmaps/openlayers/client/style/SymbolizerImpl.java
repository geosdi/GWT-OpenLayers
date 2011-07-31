package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class SymbolizerImpl {

	public native static JSObject create() /*-{
		return $wnd.OpenLayers.Symbolizer();
	}-*/;
	
	public native static void setZIndex(JSObject self, int zIndex) /*-{
		self.zIndex = zIndex;
	}-*/;
	
	public native static int getZIndex(JSObject self) /*-{
		return self.zIndex;
	}-*/;
}
