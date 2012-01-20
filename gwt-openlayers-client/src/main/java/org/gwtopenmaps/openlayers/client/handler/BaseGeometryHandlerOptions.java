package org.gwtopenmaps.openlayers.client.handler;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * Base configuration options for {@link PointHandler}, {@link PathHandler}
 *
 */
public class BaseGeometryHandlerOptions extends HandlerOptions
{

    protected BaseGeometryHandlerOptions(JSObject jsObject)
    {
        super(jsObject);
    }

    public void setLayerOptions(HandlerLayerOptions options)
    {
        getJSObject().setProperty("layerOptions", options.getJSObject());
    }

}
