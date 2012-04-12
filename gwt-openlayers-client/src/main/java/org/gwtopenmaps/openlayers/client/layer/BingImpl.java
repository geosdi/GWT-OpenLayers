package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email  giuseppe.lascaleia@geosdi.org
 */
class BingImpl {

    public static native JSObject create(JSObject options) /*-{
        return new $wnd.OpenLayers.Layer.Bing(options);
    }-*/;
}
