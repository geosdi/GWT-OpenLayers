package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class StyleImpl
{

    public static native JSObject create() /*-{
        return $wnd.OpenLayers.Style();
    }-*/;
    
    public static native JSObject create(JSObject options) /*-{
        return $wnd.OpenLayers.Style(options);
    }-*/;
}
