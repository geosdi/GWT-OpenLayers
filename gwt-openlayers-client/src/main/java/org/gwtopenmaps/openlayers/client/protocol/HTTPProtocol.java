/**
 *
 */
package org.gwtopenmaps.openlayers.client.protocol;


/**
 * @author lorenzo
 *
 */
public class HTTPProtocol extends Protocol
{

    public HTTPProtocol(HTTPProtocolOptions options)
    {
        super(HTTPProtocolImpl.create(options.getJSObject()));
        // TODO Auto-generated constructor stub

    }


    @Override
    public void read(CRUDOptions options)
    {
        // TODO Auto-generated method stub
        HTTPProtocolImpl.read(this.getJSObject(), options.getJSObject());
    }


}
