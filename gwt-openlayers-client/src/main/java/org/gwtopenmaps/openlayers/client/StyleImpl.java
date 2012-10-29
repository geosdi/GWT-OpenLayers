/**
*
*/
package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
* @author Edwin Commandeur - Atlis EJS
* @author Curtis Jensen
* @author Rafael Ceravolo - LOGANN
* @author Lukas Johansson
*/
public class StyleImpl {

	//FIXME: OpenLayers.Feature.Vector.style returns a style map!
	// This stylemap contains styles, but in the case of Vector it seems to contain
	// symbolizers rather than styles.
	public static native JSObject create()
	/*-{
		return $wnd.OpenLayers.Util.extend({}, $wnd.OpenLayers.Feature.Vector.style['default']);
		//return new Object(); //do it all yourself
	}-*/;

	public static native JSObject create(String string)
	/*-{
		return new $wnd.OpenLayers.Style(string);
	}-*/;

	public static native String getId(JSObject self)
	/*-{
		return self.id;
	}-*/;

	public static native String getName(JSObject self)
	/*-{
		return self.name;
	}-*/;

	public static native void setFillOpacity(JSObject self, double o)
	/*-{
		self.fillOpacity = o;
	}-*/;

	public static native double getFillOpacity(JSObject self)
	/*-{
		return self.fillOpacity;
	}-*/;

    public static native void setRotation(JSObject self, String o)
    /*-{
        self.rotation = o;
    }-*/;

    public static native String getRotation(JSObject self)
    /*-{
        return self.rotation;
    }-*/;

	public static native void setPointRadius(JSObject self, double o)
	/*-{
		self.pointRadius = o;
	}-*/;

	public static native double getPointRadiusAsDouble(JSObject self)
	/*-{
		return self.pointRadius;
	}-*/;

	public static native void setPointRadius(JSObject self, String o)
	/*-{
		self.pointRadius = o;
	}-*/;

	public static native String getPointRadiusAsString(JSObject self)
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

	public static native void setExternalGraphic(JSObject self,
		String graphicURL)
	/*-{
		self.externalGraphic = graphicURL;
	}-*/;

	public static native String getExternalGraphic(JSObject self)
	/*-{
		return self.externalGraphic;
	}-*/;

	public static native void setGraphicSize(JSObject self, int width,
		int height)
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

	public static native void setGraphicOffset(JSObject self, int xOffset,
		int yOffset)
	/*-{
		self.graphicXOffset = xOffset;
		self.graphicYOffset = yOffset;
	}-*/;

	public static native void setBackgroundGraphic(JSObject self,
		String backgroundGraphic)
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

	public static native void setBackgroundGraphicZIndex(JSObject self,
		int backgroundGraphicZIndex)
	/*-{
		self.backgroundGraphicZIndex = backgroundGraphicZIndex;
	}-*/;

	public static native int getBackgroundGraphicZIndex(JSObject self)
	/*-{
		return self.backgroundGraphicZIndex;
	}-*/;

	public static native void setBackgroundOffset(JSObject self,
		int backgroundXOffset, int backgroundYOffset)
	/*-{
		self.backgroundXOffset = backgroundXOffset;
		self.backgroundYOffset = backgroundYOffset;
	}-*/;

	public static native void setBackgroundWidth(JSObject self,
		int backgroundWidth)
	/*-{
		self.backgroundWidth = backgroundWidth;
	}-*/;

	public static native int getBackgroundWidth(JSObject self)
	/*-{
		return self.backgroundWidth;
	}-*/;

	public static native void setBackgroundHeight(JSObject self,
		int backgroundHeight)
	/*-{
		self.backgroundHeight = backgroundHeight;
	}-*/;

	public static native int getBackgroundHeight(JSObject self)
	/*-{
		return self.backgroundHeight;
	}-*/;

	public static native void setBackgroundGraphicSize(JSObject self,
		int backgroundWidth, int backgroundHeight)
	/*-{
		self.backgroundWidth = backgroundWidth;
		self.backgroundHeight = backgroundHeight;
	}-*/;

	public static native void setLabel(JSObject self, String label)
	/*-{
		self.label = label;
	}-*/;

	public static native String getLabel(JSObject self)
	/*-{
		return self.label;
	}-*/;

	public static native void setFontColor(JSObject self, String fontColor)
	/*-{
		self.fontColor = fontColor;
	}-*/;

	public static native String getFontColor(JSObject self)
	/*-{
		return self.fontColor;
	}-*/;

	public static native void setFontSize(JSObject self, String fontSize)
	/*-{
		self.fontSize = fontSize;
	}-*/;

	public static native String getFontSize(JSObject self)
	/*-{
		return self.fontSize;
	}-*/;

	public static native void setFontFamily(JSObject self, String fontFamily)
	/*-{
		self.fontFamily = fontFamily;
	}-*/;

	public static native String getFontFamily(JSObject self)
	/*-{
		return self.fontFamily;
	}-*/;

	public static native void setFontWeight(JSObject self, String fontWeight)
	/*-{
		self.fontWeight = fontWeight;
	}-*/;

	public static native String getFontWeight(JSObject self  )
	/*-{
		return self.fontWeight;
	}-*/;

	public static native void setLabelAlign(JSObject self, String labelAlign)
	/*-{
		self.labelAlign = labelAlign;
	}-*/;

	public static native String getLabelAlign(JSObject self)
	/*-{
		return self.labelAlign;
	}-*/;

	public static native void setStrokeOpacity(JSObject self,
		double strokeOpacity)
	/*-{
		self.strokeOpacity = strokeOpacity;
	}-*/;

	public static native double getStrokeOpacity(JSObject self)
	/*-{
		return self.strokeOpacity;
	}-*/;

	public static native void setStrokeLinecap(JSObject self,
		String strokeLinecap)
	/*-{
	self.strokeLinecap=strokeLinecap;
	}-*/;

	public static native String getStrokeLinecap(JSObject self)
	/*-{
		return self.strokeLinecap;
	}-*/;

	public static native void setStrokeDashstyle(JSObject self,
		String strokeDashstyle)
	/*-{
	self.strokeDashstyle=strokeDashstyle;
	}-*/;

	public static native String getStrokeDashstyle(JSObject self)
	/*-{
		return  self.strokeDashstyle;
	}-*/;

	public static native void setFill(JSObject self, boolean fill)
	/*-{
		self.fill=fill;
	}-*/;

	public static native boolean getFill(JSObject self)
	/*-{
		return self.fill;
	}-*/;

	public static native void setStroke(JSObject self, boolean stroke)
	/*-{
		self.stroke=stroke;
	}-*/;

	public static native boolean getStroke(JSObject self)
	/*-{
		return self.stroke;
	}-*/;

	public static native void setGraphic(JSObject self, boolean graphic)
	/*-{
		self.graphic=graphic;
	}-*/;

	public static native boolean getGraphic(JSObject self)
	/*-{
		return self.graphic;
	}-*/;

	public static native void setCursor(JSObject self, String cursor)
	/*-{
		self.cursor=cursor;
	}-*/;

	public static native String getCursor(JSObject self)
	/*-{
		return self.cursor;
	}-*/;

	public static native void setGraphicName(JSObject self, String graphicName)
	/*-{
		self.graphicName=graphicName;
	}-*/;

	public static native String getGraphicName(JSObject self)
	/*-{
		return self.graphicName;
	}-*/;

	public static native void setGraphicTitle(JSObject self, String graphicTitle)
	/*-{
		self.graphicTitle=graphicTitle;
	}-*/;

	public static native String getGraphicTitle(JSObject object)
	/*-{
		self.graphicTitle;
	}-*/;

	public static native JSObject createSymbolizer(JSObject self, JSObject feature, String intent)
	/*-{
		return self.createSymbolizer(feature, intent)
	}-*/;
	public static native int getLabelXOffset(JSObject self)
	/*-{
		return self.labelXOffset;
	}-*/;

	public static native String setLabelXOffset(JSObject self, int xoffset)
	/*-{
		self.labelXOffset = xoffset;
	}-*/;

	public static native int getLabelYOffset(JSObject self)
	/*-{
		return self.labelYOffset;
	}-*/;

	public static native String setLabelYOffset(JSObject self, int yoffset)
	/*-{
		self.labelYOffset = yoffset;
	}-*/;

	public static native int getLabelSelect(JSObject self)
	/*-{
		return self.labelSelect;
	}-*/;

	public static native String setLabelSelect(JSObject self, boolean select)
	/*-{
		self.labelSelect = select;
	}-*/;
	
	public static native void setGraphicOpacity(JSObject self, double o)
	/*-{
		self.graphicOpacity = o;
	}-*/;

	public static native double getGraphicOpacity(JSObject self)
	/*-{
		return self.graphicOpacity;
	}-*/;


}
