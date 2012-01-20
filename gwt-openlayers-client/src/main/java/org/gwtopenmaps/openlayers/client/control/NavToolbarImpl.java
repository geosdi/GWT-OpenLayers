package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * Access the openlayers navtoolbar control.
 *
 * @author Emily Gouge - Refractions Research
 *
 */
public class NavToolbarImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Control.NavToolbar();
    }-*/;

    public static native JSObject create(JSObject options) /*-{
        return new $wnd.OpenLayers.Control.NavToolbar(options);
    }-*/;

}
