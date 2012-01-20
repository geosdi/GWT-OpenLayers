package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 *
 */
public class Geometry extends OpenLayersObjectWrapper
{

    public static final String LINEARRING_CLASS_NAME = "OpenLayers.Geometry.LinearRing";
    public static final String LINESTRING_CLASS_NAME = "OpenLayers.Geometry.LineString";
    public static final String POINT_CLASS_NAME = "OpenLayers.Geometry.Point";
    public static final String POLYGON_CLASS_NAME = "OpenLayers.Geometry.Polygon";
    public static final String MULTI_POLYGON_CLASS_NAME = "OpenLayers.Geometry.MultiPolygon";
    public static final String MULTI_LINE_STRING_CLASS_NAME = "OpenLayers.Geometry.MultiLineString";
    // TODO more class names

    public static Geometry narrowToGeometry(JSObject element)
    {
        return (element == null) ? null : new Geometry(element);
    }

    public static Geometry fromWKT(String wkt)
    {
        return narrowToGeometry(GeometryImpl.fromWKT(wkt));
    }

    protected Geometry(JSObject element)
    {
        super(element);
    }

    public void destroy()
    {
        GeometryImpl.destroy(getJSObject());
    }

    public Bounds getBounds()
    {
        return Bounds.narrowToBounds(GeometryImpl.getBounds(this.getJSObject()));
    }

    public String toString()
    {
        return GeometryImpl.toString(this.getJSObject());
    }

    public Geometry clone()
    {
        return narrowToGeometry(GeometryImpl.clone(this.getJSObject()));
    }

    /**
     * Recalculate the bounds for the geometry.
     *
     */
    public void calculateBounds()
    {
        GeometryImpl.calculateBounds(getJSObject());
    }

    public double getArea()
    {
        return 0;
    }

    public double getLength()
    {
        return 0.0;
    }
}
