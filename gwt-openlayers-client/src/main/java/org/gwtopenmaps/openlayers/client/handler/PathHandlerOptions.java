package org.gwtopenmaps.openlayers.client.handler;

import org.gwtopenmaps.openlayers.client.StyleMap;
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

    /**
     * Set the stylemap to use.
     * @param styleMap The stylemap to use.
     */
    public void setStyleMap(StyleMap styleMap)
    {
        JSObject styleOption = JSObject.createJSObject();
        styleOption.setProperty("styleMap", styleMap.getJSObject());
        this.getJSObject().setProperty("layerOptions", styleOption);
    }
}
