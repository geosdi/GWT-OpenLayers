package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * See {@link Attribution}.
 *
 * @author Edwin Commandeur
 *
 */
class AttributionImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Control.Attribution();
    }-*/;

    public static native JSObject create(JSObject options) /*-{
        return new $wnd.OpenLayers.Control.Attribution(options);
    }-*/;

}
