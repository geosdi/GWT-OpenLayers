package org.gwtopenmaps.openlayers.client.handler;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author rhs - Roland.Schweitzer@noaa.gov
 *
 */
public class RegularPolygonHandler extends Handler
{
    public static RegularPolygonHandler narrowToRegularPolygonHandler(
        JSObject element)
    {
        return (element == null) ? null : new RegularPolygonHandler(element);
    }

    public RegularPolygonHandler(JSObject element)
    {
        super(element);
    }

    public RegularPolygonHandler()
    {
        this(RegularPolygonHandlerImpl.create());
    }

    public void setOptions(RegularPolygonHandlerOptions options)
    {
        RegularPolygonHandlerImpl.setOptions(getJSObject(),
            options.getJSObject());
    }
}
