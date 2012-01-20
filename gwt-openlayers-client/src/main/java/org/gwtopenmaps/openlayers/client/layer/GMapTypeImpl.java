package org.gwtopenmaps.openlayers.client.layer;


import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
class GMapTypeImpl
{
// Constants
// Constants Description

    /*
     * G_NORMAL_MAP  This is the normal street map type.
     */
    public static native JSObject G_NORMAL_MAP() /*-{
        return $wnd.G_NORMAL_MAP ? $wnd.G_NORMAL_MAP : null;
    }-*/;

    /*
     * G_SATELLITE_MAP  This map type shows Google Earth satellite images.
     */
    public static native JSObject G_SATELLITE_MAP() /*-{
        return $wnd.G_SATELLITE_MAP ? $wnd.G_SATELLITE_MAP : null;
    }-*/;

    /*
     * G_HYBRID_MAP  This map type shows transparent street maps over Google Earth satellite images.
     */
    public static native JSObject G_HYBRID_MAP() /*-{
        return $wnd.G_HYBRID_MAP ? $wnd.G_HYBRID_MAP : null;
    }-*/;
}
