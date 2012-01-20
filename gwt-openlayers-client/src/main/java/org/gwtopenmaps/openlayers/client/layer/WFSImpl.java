package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * See {@link WFS}
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
class WFSImpl
{

    public static native JSObject create(String name, String url, JSObject params, JSObject options) /*-{
        return new $wnd.OpenLayers.Layer.WFS(name, url, params, options);
    }-*/;

}
