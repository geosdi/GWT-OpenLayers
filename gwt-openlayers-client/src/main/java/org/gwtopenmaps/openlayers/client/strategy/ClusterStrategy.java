package org.gwtopenmaps.openlayers.client.strategy;

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.util.JObjectArray;
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

    public void setThreshold(int threshold )
    {
        getJSObject().setProperty("threshold ", threshold );
    }

    public int getThreshold() {
        return getJSObject().getPropertyAsInt("threshold");
    }

    /**
     * Set the features for this cluster.
     * @param features
     */
    public void setFeatures(VectorFeature[] features)
    {
        JSObject[] array = new JSObject[features.length];
        for (int i = 0 ; i< features.length; i++)
        {
            array[i] = features[i].getJSObject();
        }
        JObjectArray jobjectarray = new JObjectArray(array);
        getJSObject().setProperty("features", jobjectarray.getJSObject());
    }
}
