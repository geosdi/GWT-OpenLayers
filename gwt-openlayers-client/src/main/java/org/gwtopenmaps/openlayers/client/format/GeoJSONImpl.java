package org.gwtopenmaps.openlayers.client.format;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class GeoJSONImpl
{

    public static native JSObject create()
    /*-{
            return new $wnd.OpenLayers.Format.GeoJSON();
    }-*/;

}
