package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class ScaleLineImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Control.ScaleLine();
    }-*/;

    public static native JSObject create(JSObject options) /*-{
        return new $wnd.OpenLayers.Control.ScaleLine(options);
    }-*/;
}
