package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class SymbolizerLineImpl
{

    public static native JSObject create() /*-{
        return $wnd.OpenLayers.Symbolizer.Line();
    }-*/;

    public static native void setStorkeColor(JSObject self, String color) /*-{
        self.strokeColor = color;
    }-*/;

    public static native String getStorkeColor(JSObject self) /*-{
        return self.storkeColor;
    }-*/;

    public static native void setStorkeOpacity(JSObject self, double opacity) /*-{
        self.strokeOpacity = opacity;
    }-*/;

    public static native double getStorkeOpacity(JSObject self) /*-{
        return self.storkeOpacity;
    }-*/;

    public static native void setStorkeWidth(JSObject self, int width) /*-{
        self.strokeWidth = width;
    }-*/;

    public static native int getStorkeWidth(JSObject self) /*-{
        return self.strokeWidth;
    }-*/;

    /**
     *
     * @param linecap Stroke cap type (â€œbuttâ€?, â€œroundâ€?, or â€œsquareâ€?).
     */
    public static native void setLinecap(JSObject self, String linecap) /*-{
        self.strokeLinecap = linecap;
    }-*/;

    public static native String getLinecap(JSObject self) /*-{
        return self.storkeLinecap;
    }-*/;


    /**
     * Stroke dash style according to the SLD spec.  Note that the OpenLayers values for strokeDashstyle (â€œdotâ€?, â€œdashâ€?, â€œdashdotâ€?, â€œlongdashâ€?, â€œlongdashdotâ€?, or â€œsolidâ€?) will not work in SLD, but most SLD patterns will render correctly in OpenLayers
     * @param dashstyle
     */
    public static native void setDashstyle(JSObject self, String dashstyle) /*-{
        self.strokeDashstyle = dashstyle;
    }-*/;

    public static native String getDashstyle(JSObject self) /*-{
        return self.strokeDashstyle;
    }-*/;
}
