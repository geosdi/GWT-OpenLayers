package org.gwtopenmaps.openlayers.client.protocol;

/**
 * The options object to be passed to CRUD methods of WFSProtocol.
 * The callback is necessary, therefore the public constructor forces its use.
 *
 * @author Mikael Couzic
 */
public class WFSProtocolCRUDOptions extends CRUDOptions
{

    public WFSProtocolCRUDOptions(Callback callback)
    {
        super(WFSProtocolCRUDOptionsImpl.create(callback));
    }

}
