/**
 *
 */
package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * @author Francesco
 *
 */
class GMLImpl
{

    public static native JSObject create(String name, String url) /*-{
        return new $wnd.OpenLayers.Layer.GML(name, url);
    }-*/;

    public static native JSObject create(String name, String url, JSObject options) /*-{
        return new $wnd.OpenLayers.Layer.GML(name, url, options);
    }-*/;

    public static native void loadGML(JSObject jsObject) /*-{
        jsObject.loadGML();
    }-*/;

}
