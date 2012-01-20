/**
 *
 */
package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class LineString extends Curve
{

    public static LineString narrowToLineString(JSObject lineString)
    {
        return (lineString == null) ? null : new LineString(lineString);
    }

    protected LineString(JSObject element)
    {
        super(element);
    }

    public LineString(Point[] pts)
    {
        this(LineStringImpl.create((new JObjectArray(pts)).getJSObject()));
    }

}
