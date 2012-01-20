package org.gwtopenmaps.openlayers.client.style;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class SymbolizerRasterImpl
{

    public static native JSObject create() /*-{
        return $wnd.OpenLayers.Symbolizer.Raster();
    }-*/;

    public static native JSObject create(JSObject config) /*-{
        return $wnd.OpenLayers.Symbolizer.Raster(config);
    }-*/;
}
