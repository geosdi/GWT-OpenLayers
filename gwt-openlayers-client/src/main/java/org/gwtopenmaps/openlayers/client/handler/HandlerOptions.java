package org.gwtopenmaps.openlayers.client.handler;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;


public class HandlerOptions extends JSObjectWrapper
{

    protected HandlerOptions(JSObject jsObject)
    {
        super(jsObject);
    }

    /**
     *
     * @param keyMask Use bitwise operators and one or more of the OpenLayers.Handler constants to construct a keyMask.
     */
    public void setKeyMask(int keyMask)
    {
        getJSObject().setProperty("keyMask", keyMask);
    }
}
