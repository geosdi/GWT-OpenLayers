package org.gwtopenmaps.openlayers.client.protocol;

import org.gwtopenmaps.openlayers.client.format.Format;
import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;


/**
 * ProtocolOptions base class
 *
 * @author davek<at>komacke<dot>com
 */
public class ProtocolOptions extends JSObjectWrapper
{

    protected ProtocolOptions(JSObject jsObject)
    {
        super(jsObject);
    }

    public ProtocolOptions()
    {
        this(JSObject.createJSObject());
    }

    public void setFormat(Format format)
    {
        getJSObject().setProperty("format", format.getJSObject());
    }

}
