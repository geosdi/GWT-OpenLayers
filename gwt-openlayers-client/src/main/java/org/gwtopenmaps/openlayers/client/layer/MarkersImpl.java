package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 * @author Wayne Fang - Refractions Research
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
class MarkersImpl
{

    public static native JSObject create(String name) /*-{
        return new $wnd.OpenLayers.Layer.Markers(name);
    }-*/;

    public static native JSObject create(String name, JSObject options) /*-{
        return new $wnd.OpenLayers.Layer.Markers(name, options);
    }-*/;

    public static native void addMarker(JSObject markers, JSObject marker) /*-{
        markers.addMarker(marker);
    }-*/;

    public static native void removeMarker(JSObject markers, JSObject marker) /*-{
        markers.removeMarker(marker);
    }-*/;

    public static native void clearMarkers(JSObject markers) /*-{
        markers.clearMarkers();
    }-*/;

    public static native JSObject getDataExtent(JSObject markers) /*-{
        return markers.getDataExtent();
    }-*/;

    public static native void destroy(JSObject markers) /*-{
        markers.destroy();
    }-*/;
}
