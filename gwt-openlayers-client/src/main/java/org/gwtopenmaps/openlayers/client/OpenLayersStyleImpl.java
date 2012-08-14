package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class OpenLayersStyleImpl
{

    public static native JSObject create(JSObject styleRules) /*-{
        return new $wnd.OpenLayers.Style(styleRules);
    }-*/; 
    
    public static native JSObject create(JSObject styleRules, JSObject options) /*-{
        return new $wnd.OpenLayers.Style(styleRules, options);
    }-*/;

}
