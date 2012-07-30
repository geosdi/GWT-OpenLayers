package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * See {@link TouchsNavigation}.
 *
 * @author Jon Britton
 */
class TouchNavigationImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Control.TouchNavigation();
    }-*/;

    public static native JSObject create(JSObject options) /*-{
        return new $wnd.OpenLayers.Control.TouchNavigation(options);
    }-*/;

}
