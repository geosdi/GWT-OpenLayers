/**
 *
 */
package org.gwtopenmaps.openlayers.client.protocol;


/**
 * @author lorenzo
 *
 */
public class HTTPProtocolCRUDOptions extends CRUDOptions
{

    public HTTPProtocolCRUDOptions(Callback callback)
    {
        super(HTTPProtocolCRUDOptionsImpl.create(callback));
    }

}
