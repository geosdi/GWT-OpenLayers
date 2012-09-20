package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JStringArray;


/**
 * The javascript implementation of the class OSM is defined in a small add-on
 * javascript library for OpenStreetMap.
 *
 * See: http://openstreetmap.org/openlayers/OpenStreetMap.js
 */
public class OSM extends Layer
{

    public static OSM THIS(String name, String url, OSMOptions options)
    {
        return new OSM(OSMImpl.OSM(name, url, options.getJSObject()));
    }

    public static OSM Mapnik(String name)
    {
        return new OSM(OSMImpl.Mapnik(name));
    }

    public static OSM Mapnik(String name, OSMOptions options)
    {
        return new OSM(OSMImpl.Mapnik(name, options.getJSObject()));
    }

    public static OSM CycleMap(String name)
    {
        return new OSM(OSMImpl.CycleMap(name));
    }

    public static OSM CycleMap(String name, OSMOptions options)
    {
        return new OSM(OSMImpl.CycleMap(name, options.getJSObject()));
    }

    public static OSM Maplint(String name)
    {
        return new OSM(OSMImpl.Maplint(name));
    }

    public static OSM Maplint(String name, OSMOptions options)
    {
        return new OSM(OSMImpl.Maplint(name, options.getJSObject()));
    }

    protected OSM(JSObject element)
    {
        super(element);
    }

    public OSM()
    {
        super(OSMImpl.OSM());
    }

    public OSM(String name, String url, OSMOptions options)
    {
        super(OSMImpl.OSM(name, url, options.getJSObject()));
    }

    public OSM(String name, String[] urls, OSMOptions options) {
        this(OSMImpl.OSM(name, new JStringArray(urls).getJSObject(), options.getJSObject()));
    }


}
