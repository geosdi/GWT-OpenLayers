package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * JSNI wrapper to create and wrap access to the OpenLayers.Layer.XYZ JSObject
 * @author Andrew Hughes
 * @see XYZ
 * @see XYZOptions
 */
class XYZImpl
{

    public static native JSObject create(String name, String url, JSObject options) /*-{
        return new $wnd.OpenLayers.Layer.XYZ(name, url, options);
    }-*/;

}
