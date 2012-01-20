package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class ZoomOutImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Control.ZoomOut();
    }-*/;

}
