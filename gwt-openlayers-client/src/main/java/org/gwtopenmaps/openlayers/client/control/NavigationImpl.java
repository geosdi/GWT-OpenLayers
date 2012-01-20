package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * See {@link Navigation}.
 *
 * @author Edwin Commandeur
 *
 */
class NavigationImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Control.Navigation();
    }-*/;

    public static native JSObject create(JSObject options) /*-{
        return new $wnd.OpenLayers.Control.Navigation(options);
    }-*/;

}
