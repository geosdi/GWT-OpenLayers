package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class SymbolizerPolygonImpl
{

    public static native JSObject create() /*-{
        return $wnd.OpenLayers.Symbolizer.Polygon();
    }-*/;

    public static native void setFillColor(JSObject self, String color) /*-{
        self.fillColor = color;
    }-*/;

    public static native String getFillColor(JSObject self) /*-{
        return self.fillColor;
    }-*/;

    public static native void setFillOpacity(JSObject self, double opacity) /*-{
        self.fillOpacity = opacity;
    }-*/;

    public static native double getFillOpacity(JSObject self) /*-{
        return self.fillOpacity;
    }-*/;
}
