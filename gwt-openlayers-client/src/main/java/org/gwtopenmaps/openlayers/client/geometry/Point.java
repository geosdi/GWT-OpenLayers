package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * ...
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class Point extends Geometry
{

    public static Point narrowToPoint(JSObject point)
    {
        return (point == null) ? null : new Point(point);
    }

    protected Point(JSObject point)
    {
        super(point);
    }

    /**
     *
     * @param x - double
     * @param y - double
     */
    public Point(double x, double y)
    {
        super(PointImpl.create(x, y));
    }

    public double getX()
    {
        return PointImpl.getX(getJSObject());
    }

    public double getY()
    {
        return PointImpl.getY(getJSObject());
    }

    public String getId()
    {
        return PointImpl.getId(getJSObject());
    }

    public void setX(double x)
    {
        PointImpl.setX(getJSObject(), x);
    }

    public void setY(double y)
    {
        PointImpl.setY(getJSObject(), y);
    }

    public double[] getXY()
    {
        double[] xy = { this.getX(), this.getY() };

        return xy;
    }

    public void setXY(double x, double y)
    {
        this.setX(x);
        this.setY(y);
    }

    /**
     * APIMethod: equals Determine whether another geometry is equivalent to
     * this one. Geometries are considered equivalent if all components have the
     * same coordinates.
     *
     * Parameters: p - {<OpenLayers.Geometry.Point>} The geometry to test.
     *
     * Returns: {Boolean} The supplied geometry is equivalent to this geometry.
     */
    public boolean equals(Point p)
    {
        return PointImpl.equals(getJSObject(), p.getJSObject());
    }

    /**
     * Translate the x,y properties of the point from source to dest.
     *
     * @param source
     * @param dest
     */
    public void transform(Projection source, Projection dest)
    {
        PointImpl.transform(getJSObject(), source.getJSObject(),
            dest.getJSObject());
    }

    /**
     * Rotate a point around another.
     *
     * @param angle Rotation angle in degrees (measured counterclockwise from
     *  the positive x-axis).
     * @param origin Center point for the rotation.
     */
    public void rotate(float angle, Point origin)
    {
        PointImpl.rotate(getJSObject(), angle, origin.getJSObject());
    }

    /**
     * @return The centroid of the point
     */
    public Point getCentroid()
    {
        return new Point(PointImpl.getCentroid(getJSObject()));
    }
}
