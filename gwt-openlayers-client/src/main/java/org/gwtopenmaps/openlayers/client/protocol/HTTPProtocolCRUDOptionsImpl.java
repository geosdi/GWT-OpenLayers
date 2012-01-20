/**
 *
 */
package org.gwtopenmaps.openlayers.client.protocol;

import org.gwtopenmaps.openlayers.client.protocol.CRUDOptions.Callback;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author lorenzo
 *
 */
public class HTTPProtocolCRUDOptionsImpl
{

    public static native JSObject create(Callback callback)
    /*-{
            var options = {
                    callback: function(obj) {
                            var response = @org.gwtopenmaps.openlayers.client.protocol.Response::narrowToResponse(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(obj);
                    callback.@org.gwtopenmaps.openlayers.client.protocol.CRUDOptions.Callback::computeResponse(Lorg/gwtopenmaps/openlayers/client/protocol/Response;)(response);
                    }};
            return options;
    }-*/;

}
