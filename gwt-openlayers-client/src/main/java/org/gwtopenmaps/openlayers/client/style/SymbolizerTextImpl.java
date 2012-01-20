package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class SymbolizerTextImpl
{

    public static native JSObject create(JSObject config) /*-{
        return $wnd.OpenLayers.Symbolizer.Text(config);
    }-*/;

    public static native JSObject create() /*-{
        return $wnd.OpenLayers.Symbolizer.Text();
    }-*/;

    public static native void setLabel(JSObject self, String label) /*-{
        self.label = label;
    }-*/;

    public static native String getLabel(JSObject self) /*-{
        return self.label;
    }-*/;

    public static native void setFontFamily(JSObject self, String fontFamily) /*-{
        self.fontFamily = fontFamily;
    }-*/;

    public static native String getFontFamily(JSObject self) /*-{
        return self.fontFamily;
    }-*/;

    public static native void setFontSize(JSObject self, String fontSize) /*-{
        self.fontSize = fontSize;
    }-*/;

    public static native String getFontSize(JSObject self) /*-{
        return self.fontSize;
    }-*/;

    public static native void setFontWeight(JSObject self, String fontWeight) /*-{
        self.fontWeight = fontWeight;
    }-*/;

    public static native String getFontWeight(JSObject self) /*-{
        return self.fontWeight;
    }-*/;

    public static native void setFontStyle(JSObject self, String fontStyle) /*-{
        self.fontStyle = fontStyle;
    }-*/;

    public static native String getFontStyle(JSObject self) /*-{
        return self.fontStyle;
    }-*/;
}
