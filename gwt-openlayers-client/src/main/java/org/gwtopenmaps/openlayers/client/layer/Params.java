package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;


public abstract class Params extends JSObjectWrapper
{

    protected Params(JSObject jsObject)
    {
        super(jsObject);
    }

    /**
     * For generically setting parameters on Params objects.
     *
     * Can be used to set vendor specific parameters, such as as paramaters that are added
     * to a WMS request, but that are not part of the WMS standard, but that are supported by
     * a specific product.
     *
     * @param name
     * @param value
     */
    public void setParameter(String name, String value)
    {
        getJSObject().setProperty(name, value);
    }
}
