package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author giuseppe
 *
 */
public class MultiLineString extends Collection
{

    public static MultiLineString narrowToMultiLineString(JSObject multiLine)
    {
        return (multiLine == null) ? null : new MultiLineString(multiLine);
    }

    protected MultiLineString(JSObject element)
    {
        super(element);
        // TODO Auto-generated constructor stub
    }

    public MultiLineString(LineString[] lines)
    {
        this(MultiLineStringImpl.create((new JObjectArray(lines)).getJSObject()));
    }

}
