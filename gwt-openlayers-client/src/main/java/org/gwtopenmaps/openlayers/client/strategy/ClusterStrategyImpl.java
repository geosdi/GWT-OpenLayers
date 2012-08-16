package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class ClusterStrategyImpl
{

    public static native JSObject create() /*-{
        return new $wnd.OpenLayers.Strategy.Cluster();
    }-*/;

    static void setDistance(JSObject jsObject, int distance) {
        jsObject.setProperty("distance", distance);
    }
}
