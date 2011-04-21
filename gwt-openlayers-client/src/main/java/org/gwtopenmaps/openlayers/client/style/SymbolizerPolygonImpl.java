package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class SymbolizerPolygonImpl {
	
	public native static JSObject create() /*-{
		return $wnd.OpenLayers.Symbolizer.Polygon();
	}-*/;

	public native static void setFillColor(JSObject self, String color) /*-{
		self.fillColor = color;
	}-*/;
	
	public native static String getFillColor(JSObject self) /*-{
		return self.fillColor;
	}-*/;
	
	public native static void setFillOpacity(JSObject self, double opacity) /*-{
		self.fillOpacity = opacity;
	}-*/;
	
	public native static double getFillOpacity(JSObject self) /*-{
		return self.fillOpacity;
	}-*/;
}
