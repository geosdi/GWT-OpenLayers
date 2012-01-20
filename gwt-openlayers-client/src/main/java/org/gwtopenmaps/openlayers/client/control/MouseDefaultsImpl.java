package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Curtis Jensen
 *
 */
class MouseDefaultsImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Control.MouseDefaults();
    }-*/;

    public static native JSObject create(JSObject options) /*-{
        return new $wnd.OpenLayers.Control.MouseDefaults(options);
    }-*/;
}
