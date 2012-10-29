package org.gwtopenmaps.openlayers.client.protocol;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author davek<at>komacke<dot>com
 * @author Mikael Couzic
 */
public class WFSProtocolImpl {

    public static native JSObject create(JSObject options) /*-{
        return new $wnd.OpenLayers.Protocol.WFS(options);
    }-*/;

    public static native JSObject create(JSObject layer,
            JSObject options) /*-{
        return new $wnd.OpenLayers.Protocol.WFS.fromWMSLayer(layer, options);
    }-*/;

    public static native void read(JSObject protocol,
            JSObject options) /*-{
        protocol.read(options);
    }-*/;

    public static native void commit(JSObject protocol,
            JSObject features,
            JSObject options) /*-{
        protocol.commit(features, options);
    }-*/;
}
