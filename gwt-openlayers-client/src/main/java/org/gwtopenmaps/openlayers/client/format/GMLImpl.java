package org.gwtopenmaps.openlayers.client.format;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Mikael Couzic
 *
 */
public class GMLImpl
{

    public static native JSObject create()
    /*-{
                    return new $wnd.OpenLayers.Format.GML();
    }-*/;

}
