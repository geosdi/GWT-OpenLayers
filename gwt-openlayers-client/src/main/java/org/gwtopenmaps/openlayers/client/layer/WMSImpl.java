package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 *             Amr Alam - Refractions Research
 *         Curtis Jensen
 */
class WMSImpl
{

    public static native JSObject create(String name, String url, JSObject params) /*-{
        return new $wnd.OpenLayers.Layer.WMS(name, url, params);
    }-*/;

    public static native JSObject create(String name, String url, JSObject params, JSObject layerParams) /*-{
        return new $wnd.OpenLayers.Layer.WMS(name, url, params, layerParams);
    }-*/;

    public static native JSObject create(String name, JSObject urls, JSObject params) /*-{
        // JavaScript can loose the type of objects.
        // the Array that was created in JArrayBaseImpl is reported as an "object"
        // when the OpenLayers code checks for instanceof Array.  Converting the passed in urls Array to a new Array corrects this problem.
        // There may be a better way, until it is figured out, this is what is done.
        
        var wmsURLs = new $wnd.Array(urls.length);
        for (i = 0; i < urls.length; i++) {
        wmsURLs[i] = urls[i];
        }
        
        return new $wnd.OpenLayers.Layer.WMS(name, wmsURLs, params);
    }-*/;

    public static native JSObject create(String name, JSObject urls, JSObject params, JSObject layerParams) /*-{
        // JavaScript can loose the type of objects.
        // the Array that was created in JArrayBaseImpl is reported as an "object"
        // when the OpenLayers code checks for instanceof Array.  Converting the passed in urls Array to a new Array corrects this problem.
        // There may be a better way, until it is figured out, this is what is done.
        
        var wmsURLs = new $wnd.Array(urls.length);
        for (i = 0; i < urls.length; i++) {
        wmsURLs[i] = urls[i];
        }
        
        return new $wnd.OpenLayers.Layer.WMS(name, wmsURLs, params, layerParams);
    }-*/;

    public static native int getNumLoadingTiles(JSObject layer) /*-{
        return layer.numLoadingTiles;
    }-*/;
}
