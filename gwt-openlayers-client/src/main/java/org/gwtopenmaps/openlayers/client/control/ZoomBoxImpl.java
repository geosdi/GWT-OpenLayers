package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class ZoomBoxImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Control.ZoomBox();
    }-*/;

    public static native JSObject create(JSObject options) /*-{
        return new $wnd.OpenLayers.Control.ZoomBox(options);
    }-*/;

}
