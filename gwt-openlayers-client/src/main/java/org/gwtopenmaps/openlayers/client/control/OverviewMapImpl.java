package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class OverviewMapImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Control.OverviewMap();
    }-*/;

    public static native JSObject create(JSObject params) /*-{
        return new $wnd.OpenLayers.Control.OverviewMap(params);
    }-*/;
}
