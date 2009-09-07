/**
 * 
 */
package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 * 
 */
public class StyleImpl {

	public static native JSObject create()
	/*-{
	    return $wnd.OpenLayers.Util.extend({}, $wnd.OpenLayers.Feature.Vector.style['default']);
	    //return new Object(); //do it all yourself
	}-*/;

	public static native void setFillColor(JSObject self, String s)
	/*-{
	    self.fillColor = s;
	}-*/;

	public static native String getFillColor(JSObject self)
	/*-{
	    return self.fillColor;
	}-*/;

	public static native void setFillOpacity(JSObject self, double o)
	/*-{
	    self.fillOpacity = o;
	}-*/;

	public static native double getFillOpacity(JSObject self)
	/*-{
	    return self.fillOpacity;
	}-*/;

	public static native void setPointRadius(JSObject self, double o)
	/*-{
	    self.pointRadius = o;
	}-*/;

	public static native double getPointRadius(JSObject self)
	/*-{
	    return self.pointRadius;
	}-*/;

	public static native void setStrokeColor(JSObject self, String s)
	/*-{
	    self.strokeColor = s;
	}-*/;

	public static native String getStrokeColor(JSObject self)
	/*-{
	    return self.strokeColor;
	}-*/;

	public static native void setStrokeWidth(JSObject self, double w)
	/*-{
	    self.strokeWidth = w;
	}-*/;

	public static native double getStrokeWidth(JSObject self)
	/*-{
	    return self.strokeWidth;
	}-*/;

	public static native void setExternalGraphic(JSObject self, String graphicURL)
	/*-{
		self.externalGraphic = graphicURL;
	}-*/;

	public static native String getExternalGraphic(JSObject self)
	/*-{
		return self.externalGraphic;
	}-*/;

	public static native void setGraphicSize(JSObject self, int width, int height)
	/*-{
		self.graphicWidth = width;
		self.graphicHeight = height;
	}-*/;

	public static native int getGraphicWidth(JSObject self)
	/*-{
		return self.graphicWidth;
	}-*/;

	public static native int getGraphicHeight(JSObject self)
	/*-{
		return self.graphicHeight;
	}-*/;

	public static native void setGraphicOffset(JSObject self, int xOffset, int yOffset)
	/*-{
		self.graphicXOffset = xOffset;
		self.graphicYOffset = yOffset;
	}-*/;

	public static native void setBackgroundGraphic(JSObject self, String backgroundGraphic)
	/*-{
		self.backgroundGraphic = backgroundGraphic;
	}-*/;

	public static native String getBackgroundGraphic(JSObject self)
	/*-{
		return self.backgroundGraphic;
	}-*/;

	public static native void setGraphicZIndex(JSObject self, int graphicZIndex)
	/*-{
		self.graphicZIndex = graphicZIndex;
	}-*/;

	public static native int getGraphicZIndex(JSObject self)
	/*-{
		return self.graphicZIndex;
	}-*/;

	public static native void setBackgroundGraphicZIndex(JSObject self, int backgroundGraphicZIndex)
	/*-{
		self.backgroundGraphicZIndex = backgroundGraphicZIndex;
	}-*/;

	public static native int getBackgroundGraphicZIndex(JSObject self)
	/*-{
		return self.backgroundGraphicZIndex;
	}-*/;

	public static native void setBackgroundOffset(JSObject self, int backgroundXOffset, int backgroundYOffset)
	/*-{
		self.backgroundXOffset = backgroundXOffset;
		self.backgroundYOffset = backgroundYOffset;
	}-*/;

	public static native void setBackgroundWidth(JSObject self, int backgroundWidth)
	/*-{
		self.backgroundWidth = backgroundWidth;
	}-*/;

	public static native int getBackgroundWidth(JSObject self)
	/*-{
		return self.backgroundWidth;
	}-*/;

	public static native void setBackgroundHeight(JSObject self, int backgroundHeight)
	/*-{
		self.backgroundHeight = backgroundHeight;
	}-*/;

	public static native int getBackgroundHeight(JSObject self)
	/*-{
		return self.backgroundHeight;
	}-*/;

	public static native void setBackgroundGraphicSize(JSObject self, int backgroundWidth, int backgroundHeight)
	/*-{
		self.backgroundWidth = backgroundWidth;
		self.backgroundHeight = backgroundHeight;
	}-*/;

}
