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
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;


public class SnappingOptions extends JSObjectWrapper
{

    public SnappingOptions(JSObject object)
    {
        super(object);
    }

    public SnappingOptions()
    {
        this(JSObject.createJSArray());
    }

    /**
     * Snap to closest feature in first target layer that applies.  Default is true.  If false, all features in all target layers will be checked and the closest feature in all target layers will be chosen.  The greedy property determines if the order of the target layers is significant.  By default, the order of the target layers is significant where layers earlier in the target layer list have precedence over layers later in the list.  Within a single layer, the closest feature is always chosen for snapping.  This property only determines whether the search for a closer feature continues after an eligible feature is found in a target layer.
     * @param greedy
     */
    public void setGreedy(boolean greedy)
    {
        this.getJSObject().setProperty("greedy", greedy);
    }

    /** targets - {Array(OpenLayers.Layer.Vector)} A list of vector layers
    *     the defaults from the <defaults>
    *     property will apply.  The editable layer itself may be a target
    *     layer - allowing newly created or edited features to be snapped to
    *     existing features from the same layer.  If no targets are provided
    *     the layer given in the constructor (as <layer>) will become the
    *     initial target.
    *
    *     TODO ahhughes, which method is best?
    **/
    public void setTargets(Vector[] targets)
    {
        JSObject[] jsObjects = new JSObject[targets.length];
        for (int i = 0; i < targets.length; i++)
        {
            jsObjects[i] = targets[i].getJSObject();
        }

        JObjectArray array = new JObjectArray(jsObjects);
        getJSObject().setProperty("targets", array.getJSObject());
    }
//      public void setTargets(Vector[] vector) {
//              JSObject arrayVector = JSObject.createJSArray();
//              for(int i=0; i<vector.length; i++) {
//                      arrayVector.setProperty(i+"", vector[i].getJSObject());
//              }
//              this.getJSObject().setProperty("targets", arrayVector);
//      }

    /** targets - {Array(Object)} A list of objects for
        *     configuring target layers.  See valid properties of the target
        *     objects below.  If the items in the targets list are vector layers
        *     (instead of configuration objects), the defaults from the <defaults>
        *     property will apply.  The editable layer itself may be a target
        *     layer - allowing newly created or edited features to be snapped to
        *     existing features from the same layer.  If no targets are provided
        *     the layer given in the constructor (as <layer>) will become the
        *     initial target.
            **/
    public void setTargets(SnappingTarget[] targets)
    {
        JSObject[] jsObjects = new JSObject[targets.length];
        for (int i = 0; i < targets.length; i++)
        {
            jsObjects[i] = targets[i].getJSObject();
        }

        JObjectArray array = new JObjectArray(jsObjects);
        getJSObject().setProperty("targets", array.getJSObject());
    }

    public void setDefaults(Vector vector)
    {
        this.getJSObject().setProperty("defaults", vector.getJSObject());
    }

    public boolean getGreedy()
    {
        return getJSObject().getPropertyAsBoolean("greedy");
    }

    /**
     * Property: layer {<OpenLayers.Layer.Vector>} The current editable layer.
     * Set at construction or after construction with <setLayer>.
     */
    public void setLayer(Vector layer)
    {
        getJSObject().setProperty("layer", layer.getJSObject());
    }

    public Vector getLayer()
    {
        return Vector.narrowToVector(getJSObject().getProperty("layer"));
    }

}
