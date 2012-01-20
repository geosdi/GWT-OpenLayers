package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
class GoogleImpl
{

    public static native JSObject create(String name) /*-{
        return new $wnd.OpenLayers.Layer.Google(name);
    }-*/;

    public static native JSObject create(String name, JSObject params)
    /*-{
       return new $wnd.OpenLayers.Layer.Google(name, params);
    }-*/;

    public static native JSObject forwardMercator(JSObject google, double lon, double lat) /*-{
        return google.forwardMercator(lon, lat);
    }-*/;
}
