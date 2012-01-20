package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class MultiPolygonImpl
{

    public static native JSObject create(JSObject polygons) /*-{
        return new $wnd.OpenLayers.Geometry.MultiPolygon($wnd.gwt_openlayers_util.convertToArray(polygons));
    }-*/;

}
