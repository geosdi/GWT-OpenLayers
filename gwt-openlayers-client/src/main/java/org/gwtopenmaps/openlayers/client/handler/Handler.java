package org.gwtopenmaps.openlayers.client.handler;

import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.util.JSObject;


public class Handler extends OpenLayersObjectWrapper
{

    public static final int MOD_NONE = 0;
    public static final int MOD_SHIFT = 1;
    public static final int MOD_CTRL = 2;
    public static final int MOD_ALT = 4;

    public static final String POINT_HANDLER_CLASS_NAME = "OpenLayers.Handler.Point";
    public static final String PATH_HANDLER_CLASS_NAME = "OpenLayers.Handler.Path";
    public static final String POLYGON_HANDLER_CLASS_NAME = "OpenLayers.Handler.Polygon";
    public static final String REGULAR_POLYGON_HANDLER_CLASS_NAME = "OpenLayers.Handler.RegularPolygon";

    public static Handler narrowToHandler(JSObject element)
    {
        return (element == null) ? null : new Handler(element);
    }

    protected Handler(JSObject element)
    {
        super(element);
    }

}
