package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class SymbolizerTextImpl {

	public native static JSObject create(JSObject config) /*-{
		return $wnd.OpenLayers.Symbolizer.Text(config);
	}-*/;
	
	public native static JSObject create() /*-{
		return $wnd.OpenLayers.Symbolizer.Text();
	}-*/;

	public native static void setLabel(JSObject self, String label) /*-{
		self.label = label;
	}-*/;
	
	public native static String getLabel(JSObject self) /*-{
		return self.label;
	}-*/;
	
	public native static void setFontFamily(JSObject self, String fontFamily) /*-{
		self.fontFamily = fontFamily;
	}-*/;
	
	public native static String getFontFamily(JSObject self) /*-{
		return self.fontFamily;
	}-*/;
	
	public native static void setFontSize(JSObject self, String fontSize) /*-{
		self.fontSize = fontSize;
	}-*/;
	
	public native static String getFontSize(JSObject self) /*-{
		return self.fontSize;
	}-*/;
	
	public native static void setFontWeight(JSObject self, String fontWeight) /*-{
		self.fontWeight = fontWeight;
	}-*/;
	
	public native static String getFontWeight(JSObject self) /*-{
		return self.fontWeight;
	}-*/;
	
	public native static void setFontStyle(JSObject self, String fontStyle) /*-{
		self.fontStyle = fontStyle;
	}-*/;
	
	public native static String getFontStyle(JSObject self) /*-{
		return self.fontStyle;
	}-*/;
}
