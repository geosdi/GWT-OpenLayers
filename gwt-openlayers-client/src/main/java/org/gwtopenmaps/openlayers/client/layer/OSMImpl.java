/**
 *
 *   Copyright 2014 sourceforge.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
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
