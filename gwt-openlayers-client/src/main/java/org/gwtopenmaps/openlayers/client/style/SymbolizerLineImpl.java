package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class SymbolizerLineImpl {
	
	public native static JSObject create()/*-{
		return $wnd.OpenLayers.Symbolizer.Line();
	}-*/;
	
	public native static void setStorkeColor(JSObject self, String color) /*-{
		self.strokeColor = color;
	}-*/;
	
	public native static String getStorkeColor(JSObject self) /*-{
		return self.storkeColor;
	}-*/;
	
	public native static void setStorkeOpacity(JSObject self, double opacity) /*-{
		self.strokeOpacity = opacity;
	}-*/;
	
	public native static double getStorkeOpacity(JSObject self) /*-{
		return self.storkeOpacity;
	}-*/;
	
	public native static void setStorkeWidth(JSObject self, int width) /*-{
		self.strokeWidth = width;
	}-*/;
	
	public native static int getStorkeWidth(JSObject self) /*-{
		return self.strokeWidth;
	}-*/;
	
	/**
	 * 
	 * @param linecap Stroke cap type (“butt”, “round”, or “square”).
	 */
	public native static void setLinecap(JSObject self, String linecap) /*-{
		self.strokeLinecap = linecap;
	}-*/;
	
	public native static String getLinecap(JSObject self) /*-{
		return self.storkeLinecap;
	}-*/;
	
	
	/**
	 * Stroke dash style according to the SLD spec.  Note that the OpenLayers values for strokeDashstyle (“dot”, “dash”, “dashdot”, “longdash”, “longdashdot”, or “solid”) will not work in SLD, but most SLD patterns will render correctly in OpenLayers
	 * @param dashstyle
	 */
	public native static void setDashstyle(JSObject self, String dashstyle) /*-{
		self.strokeDashstyle = dashstyle;
	}-*/;
	
	public native static String getDashstyle(JSObject self) /*-{
		return self.strokeDashstyle;
	}-*/;
}
