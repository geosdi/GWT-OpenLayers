package org.gwtopenmaps.openlayers.client.handler;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class PolygonHandler extends PointHandler
{

    protected PolygonHandler(JSObject element)
    {
        super(element);
    }

    public PolygonHandler()
    {
        this(PolygonHandlerImpl.create());
    }

}
