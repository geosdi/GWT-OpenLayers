package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class SymbolizerPointImpl {
	
	public native static JSObject create() /*-{
		return $wnd.OpenLayers.Symbolizer.Point();
	}-*/;
	
	public native static void setPointRadius(JSObject self, double radius) /*-{
		self.pointRadius = radius;
	}-*/;
	
	public native static double getPointRadius(JSObject self) /*-{
		return self.pointRadius;
	}-*/;
	
	public native static void setExternalGraphic(JSObject self, String url) /*-{
		self.externalGraphic = url;
	}-*/;
	
	public native static String getExtenalGraphic(JSObject self) /*-{
		return self.externalGraphic;
	}-*/;
	
	public native static void setGraphicWidth(JSObject self, int width) /*-{
		self.graphicWidth = width;
	}-*/;
	
	public native static int getGraphicWidth(JSObject self) /*-{
		return self.graphicWidth;
	}-*/;
	
	public native static void setGraphicHeight(JSObject self, int height) /*-{
		self.graphicHeight = height;
	}-*/;
	
	public native static int getGraphicHeight(JSObject self) /*-{
		return self.graphicHeight;
	}-*/;
	
	public native static void setGraphicOpacity(JSObject self, double opacity) /*-{
		self.graphicOpacity = opacity;
	}-*/;
	
	public native static double getGraphicOpacity(JSObject self) /*-{
		return self.graphicOpacity;
	}-*/;
	
	public native static void setGraphicXOffset(JSObject self, int offset) /*-{
		self.graphicXOffset = offset;
	}-*/; 
	
	public native static int getGraphicXOffset(JSObject self) /*-{
		return self.graphicXOffset;
	}-*/; 
	
	public native static void setGraphicYOffset(JSObject self, int offset) /*-{
		self.graphicYOffset = offset;
	}-*/; 
	
	public native static int getGraphicYOffset(JSObject self) /*-{
		return self.graphicYOffset;
	}-*/; 
	
	public native static void setRotation(JSObject self, double rotation) /*-{
		self.rotation = rotation;
	}-*/;
	
	public native static double getRotation(JSObject self) /*-{
		return self.rotation;
	}-*/;
	
	public native static void setGraphicName(JSObject self, String name) /*-{
		self.graphicName = name;
	}-*/;
	
	public native static String getGraphicName(JSObject self) /*-{
		return self.graphicName;
	}-*/;
}
