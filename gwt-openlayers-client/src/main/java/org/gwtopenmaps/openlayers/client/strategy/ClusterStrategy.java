package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class ClusterStrategy extends Strategy
{

    protected ClusterStrategy(JSObject strategy)
    {
        super(strategy);
    }

    public ClusterStrategy()
    {
        this(ClusterStrategyImpl.create());
    }
    
    public void setDistance(int distance) {
        getJSObject().setProperty("distance", distance);
    }
    
    public int getDistance() {
        return getJSObject().getPropertyAsInt("distance");
    }
}
