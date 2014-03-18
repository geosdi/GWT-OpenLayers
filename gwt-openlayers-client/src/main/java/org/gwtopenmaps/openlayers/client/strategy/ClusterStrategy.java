/**
 *
 *   Copyright 2014 sourceforge.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
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
        getJSObject().setProperty("threshold", threshold );
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
