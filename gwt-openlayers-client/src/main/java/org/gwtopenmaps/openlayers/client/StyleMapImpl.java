package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Rafael Ceravolo - LOGANN
 */
public class StyleMapImpl {
    /** Creates a StyleMap JSObject with the default properties */
    public static native JSObject create()
    /*-{
        return new $wnd.OpenLayers.StyleMap();
        //return new Object(); //do it all yourself
    }-*/;

    public static native JSObject create(JSObject style)
    /*-{
        return new $wnd.OpenLayers.StyleMap(style);
        //return new Object(); //do it all yourself
    }-*/;

    public static native JSObject create(JSObject defaultStyle,
	    JSObject selectStyle, JSObject temporaryStyle)
    /*-{
        return new $wnd.OpenLayers.StyleMap({
            "default" : defaultStyle, 
            "select" : selectStyle,
            "temporary" : temporaryStyle
        });
        //return new Object(); //do it all yourself
    }-*/;
}
