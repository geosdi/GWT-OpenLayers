package org.gwtopenmaps.openlayers.client.format;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * Wraps OpenLayers.Format.GML.v2
 *
 * Brief explanation of Geographic Markup Language (GML) vector format here.
 *
 * Reference to GML specification. GML is OGC standard.
 *
 * See http://www.ogc.org/
 *
 * @author Edwin Commandeur - Atlis EJS
 * @author Mikael Couzic
 */
public class GML2 extends VectorFormat
{

    protected GML2(JSObject gmlFormat)
    {
        super(gmlFormat);
    }

    /**
     * Unique constructor taking required options as a parameter.
     * @param options
     *                              required options
     */
    public GML2(GML2Options options)
    {
        this(GML2Impl.create(options.getJSObject()));
    }

}
