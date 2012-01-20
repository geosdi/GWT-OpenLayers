package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 *
 */
class LayerSwitcherImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Control.LayerSwitcher();
    }-*/;

    public static native JSObject create(JSObject options) /*-{
        return new $wnd.OpenLayers.Control.LayerSwitcher(options);
    }-*/;

}
