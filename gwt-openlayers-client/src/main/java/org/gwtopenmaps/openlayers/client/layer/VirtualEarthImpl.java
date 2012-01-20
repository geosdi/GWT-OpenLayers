package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class VirtualEarthImpl
{

    public static native JSObject create(String name) /*-{
        return new $wnd.OpenLayers.Layer.VirtualEarth("Shaded", {
        type: $wnd.VEMapStyle.Shaded
        });
    }-*/;

    public static native JSObject create(String name, JSObject params) /*-{
        return new $wnd.OpenLayers.Layer.VirtualEarth(name, params);
    }-*/;

}
