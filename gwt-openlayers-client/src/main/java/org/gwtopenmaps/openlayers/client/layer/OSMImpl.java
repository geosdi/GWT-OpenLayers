package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class OSMImpl
{

    public static native JSObject OSM()
    /*-{
       return new $wnd.OpenLayers.Layer.OSM();
    }-*/;

    public static native JSObject OSM(String name, String url, JSObject params)
    /*-{
       return new $wnd.OpenLayers.Layer.OSM(name, url, params);
    }-*/;

    public static native JSObject OSM(String name, JSObject urls, JSObject params)
    /*-{
        var wmsURLs = new $wnd.Array(urls.length);
        for (i = 0; i < urls.length; i++) {
        wmsURLs[i] = urls[i];
        }

        return new $wnd.OpenLayers.Layer.OSM(name, wmsURLs, params);
    }-*/;

    public static native JSObject Mapnik(String name)
    /*-{
       return new $wnd.OpenLayers.Layer.OSM.Mapnik(name);
    }-*/;

    public static native JSObject Mapnik(String name, JSObject params)
    /*-{
       return new $wnd.OpenLayers.Layer.OSM.Mapnik(name, params);
    }-*/;

    public static native JSObject CycleMap(String name)
    /*-{
       return new $wnd.OpenLayers.Layer.OSM.CycleMap(name);
    }-*/;

    public static native JSObject CycleMap(String name, JSObject params)
    /*-{
       return new $wnd.OpenLayers.Layer.OSM.CycleMap(name, params);
    }-*/;

    public static native JSObject Maplint(String name)
    /*-{
       return new $wnd.OpenLayers.Layer.OSM.Maplint(name);
    }-*/;

    public static native JSObject Maplint(String name, JSObject params)
    /*-{
       return new $wnd.OpenLayers.Layer.OSM.Maplint(name, params);
    }-*/;

}
