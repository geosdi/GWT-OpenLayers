package org.gwtopenmaps.openlayers.client.format;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Mikael Couzic
 */
public class GML3Impl
{

    public static native JSObject create(JSObject options)
    /*-{
            return new $wnd.OpenLayers.Format.GML.v3(options);
    }-*/;

}
