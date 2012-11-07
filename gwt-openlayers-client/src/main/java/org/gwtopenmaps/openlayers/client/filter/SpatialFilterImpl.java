package org.gwtopenmaps.openlayers.client.filter;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Frank Wynants
 */
public class SpatialFilterImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Filter.Spatial();
    }-*/;


}
