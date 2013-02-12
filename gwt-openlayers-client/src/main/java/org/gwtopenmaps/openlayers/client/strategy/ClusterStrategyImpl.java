package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class ClusterStrategyImpl
{

    public static native JSObject create() /*-{
        console.log(new $wnd.OpenLayers.Strategy.Cluster());
        return new $wnd.OpenLayers.Strategy.Cluster();
    }-*/;
}
