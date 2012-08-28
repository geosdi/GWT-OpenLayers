package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class PointImpl
{

    public static native JSObject create(double x, double y) /*-{
        return new $wnd.OpenLayers.Geometry.Point(x, y);
    }-*/;

    public static native double getX(JSObject self) /*-{
        return self.x;
    }-*/;

    public static native double getY(JSObject self) /*-{
        return self.y;
    }-*/;

    public static native String getId(JSObject self) /*-{
        return self.id;
    }-*/;

    public static native void setX(JSObject self, double x) /*-{
        self.x = x;
    }-*/;

    public static native void setY(JSObject self, double y) /*-{
        self.y = y;
    }-*/;

    public static native boolean equals(JSObject self, JSObject geom) /*-{
        self.equals(geom);
    }-*/;

    public static native void transform(JSObject self, JSObject source, JSObject dest) /*-{
        self.transform(source, dest);
    }-*/;

    public static native void rotate(JSObject self, float angle, JSObject origin) /*-{
        self.rotate(angle, origin);
    }-*/;

    public static native JSObject getCentroid(JSObject self) /*-{
    return self.getCentroid();
    }-*/;
}