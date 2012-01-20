package org.gwtopenmaps.openlayers.client.protocol;

import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * Protocol abstract base class
 *
 * @author davek<at>komacke<dot>com
 */

public abstract class Protocol extends OpenLayersObjectWrapper
{

    protected Protocol(JSObject protocol)
    {
        super(protocol);
    }

    public abstract void read(CRUDOptions options);

}
