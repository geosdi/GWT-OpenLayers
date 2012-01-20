package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class GridLayerImpl
{

    public static native JSObject create(String name, String url,
        JSObject params, JSObject options) /*-{
        return new $wnd.OpenLayers.Layer.Grid(name, url, params,options);
    }-*/;

    public static native JSObject create(String name, String url,
        JSObject params) /*-{
        return new $wnd.OpenLayers.Layer.Grid(name, url, params);
    }-*/;

    public static native void setTitleSize(JSObject self, int tileSize) /*-{
        self.tileSize = tileSize;
    }-*/;

    public static native void setSingleTile(JSObject self, boolean singleTile) /*-{
        self.singleTile = singleTile;
    }-*/;

    public static native void setRatio(JSObject self, float ratio) /*-{
        self.ratio = ratio;
    }-*/;

    public static native void setBuffer(JSObject self, Integer buffer) /*-{
        self.buffer = buffer;
    }-*/;

    public static native void setNumLoadingTiles(JSObject self, Integer numLoadingTiles) /*-{
        self.numLoadingTiles = numLoadingTiles;
    }-*/;
}
