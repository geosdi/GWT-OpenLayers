package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class LinearRing extends LineString
{

    public static LinearRing narrowToLinearRing(JSObject linearRing)
    {
        return (linearRing == null) ? null : new LinearRing(linearRing);
    }

    public static LinearRing fromCoordinateArray(double[][] coordinateArray)
    {
        int max = coordinateArray.length;
        Point[] pts = new Point[max];
        for (int i = 0; i < max; i++)
        {
            Point p = new Point(coordinateArray[i][0], coordinateArray[i][1]);
            pts[i] = p;
        }

        LinearRing ring = new LinearRing(pts);

        return ring;
    }

    protected LinearRing(JSObject linearRing)
    {
        super(linearRing);
    }

    public LinearRing(Point[] pts)
    {
        this(LinearRingImpl.create((new JObjectArray(pts).getJSObject())));
    }
}
