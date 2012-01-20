/**
 *
 */
package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 *
 */
public class GeometryImpl
{

    public static native void destroy(JSObject self) /*-{
        self.destroy();
    }-*/;

    public static native JSObject getBounds(JSObject geom) /*-{
        return geom.getBounds();
    }-*/;

    public static native String toString(JSObject geom) /*-{
        return geom.toString();
    }-*/;

    public static native JSObject fromWKT(String wkt) /*-{
        return $wnd.OpenLayers.Geometry.fromWKT(wkt);
    }-*/;

    public static native JSObject clone(JSObject geom) /*-{
        return geom.clone();
    }-*/;

    public static native void calculateBounds(JSObject geom) /*-{
        geom.calculateBounds();
    }-*/;
}
