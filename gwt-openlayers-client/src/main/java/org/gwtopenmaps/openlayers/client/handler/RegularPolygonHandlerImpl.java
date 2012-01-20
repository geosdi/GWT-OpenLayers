package org.gwtopenmaps.openlayers.client.handler;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class RegularPolygonHandlerImpl
{
    public static native JSObject create() /*-{
        return $wnd.OpenLayers.Handler.RegularPolygon;
    }-*/;

    public static native void setOptions(JSObject handler, JSObject options) /*-{
        handler.setOptions(options);
    }-*/;
}
