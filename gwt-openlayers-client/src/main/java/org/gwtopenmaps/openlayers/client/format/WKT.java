package org.gwtopenmaps.openlayers.client.format;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * Brief explanation of Well Known Text (WKT) vector format here.
 *
 * Reference to WKT specification.
 *
 * @author Edwin Commandeur - Atlis EJS
 */
public class WKT extends VectorFormat
{

    protected WKT(JSObject wktFormat)
    {
        super(wktFormat);
    }

    public WKT()
    {
        this(WKTImpl.create());
    }

}
