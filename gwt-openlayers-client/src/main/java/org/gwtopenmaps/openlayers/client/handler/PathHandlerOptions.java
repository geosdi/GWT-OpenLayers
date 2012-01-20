package org.gwtopenmaps.openlayers.client.handler;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * Options which control the behavior of the RegularPolygonHandler
 * @author rhs - Roland.Schweitzer@noaa.gov
 *
 */
public class PathHandlerOptions extends HandlerOptions
{

    protected PathHandlerOptions(JSObject jsObject)
    {
        super(jsObject);
    }

    public PathHandlerOptions()
    {
        this(JSObject.createJSObject());
    }
}
