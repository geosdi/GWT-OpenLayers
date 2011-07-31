package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.feature.Feature;
import org.gwtopenmaps.openlayers.client.util.JSObject;

public class SymbolizerMapImpl {

	public native static JSObject create() /*-{
		return $wnd.OpenLayers.StyleMap();
	}-*/;
	
	public native static JSObject create(JSObject style, JSObject options) /*-{
		return $wnd.OpenLayers.StyleMap(style, options);
	}-*/;
	
	public native static JSObject createSymbolizer(JSObject self, Feature feature, String intent) /*-{
		return self.createSymbolizer(feature, intent);
	}-*/;
}
