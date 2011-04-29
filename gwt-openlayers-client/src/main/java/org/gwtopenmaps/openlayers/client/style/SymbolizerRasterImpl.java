package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class SymbolizerRasterImpl {
	
	public native static JSObject create() /*-{
		return $wnd.OpenLayers.Symbolizer.Raster();
	}-*/;
	
	public native static JSObject create(JSObject config) /*-{
		return $wnd.OpenLayers.Symbolizer.Raster(config);
	}-*/;
}
