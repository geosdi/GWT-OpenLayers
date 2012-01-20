package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class Polygon extends Collection
{

    public static Polygon narrowToPolygon(JSObject polygon)
    {
        return (polygon == null) ? null : new Polygon(polygon);
    }

    protected Polygon(JSObject element)
    {
        super(element);
    }

    public Polygon(LinearRing[] rings)
    {
        this(PolygonImpl.create((new JObjectArray(rings)).getJSObject()));
    }

    /**
     * Polygons are composed of LinearRing geometries.
     * LinearRing geometries are MultiPoint geometries, whose components are Points.
     * The first and last component of a LinearRing is the same point,
     * even if a LinearRing is instantiated with an array of Points whose first and last point are not the same.
     * @return Array of LinearRing Objects
     */
    public LinearRing[] getComponents()
    {
        int max = getNumberOfComponents();
        LinearRing[] components = new LinearRing[max];
        for (int i = 0; i < max; i++)
        {
            components[i] = LinearRing.narrowToLinearRing(getComponent(i));
        }

        return components;
    }

    /**
     * Determine if the input geometry intersects this one.
     * @param geometry  Any type of geometry.
     * @return The input geometry intersects this one.
     */
    public boolean intersects(Geometry geometry)
    {
        return PolygonImpl.intersects(getJSObject(), geometry.getJSObject());
    }


    public double getArea()
    {
        return PolygonImpl.getArea(getJSObject());
    }

    public double getGeodesicArea(Projection projection)
    {
        return PolygonImpl.getGeodesicArea(getJSObject(),
                projection.getJSObject());
    }

}
