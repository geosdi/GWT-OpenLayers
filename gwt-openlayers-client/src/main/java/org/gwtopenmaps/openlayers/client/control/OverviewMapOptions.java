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
/**
 *
 */
package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.util.JObjectArray;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class OverviewMapOptions extends ControlOptions
{


    /**
     * If no layers are set at the construction of the {@link OverviewMap} control then
     * the base layer of the map to which the {@link OverviewMap} control instance is added
     * is used as layer in the overviewmap.
     *
     * The default behaviour does not work if base layer opacity is less than 1 (known issue?).
     *
     * @param layers
     */
    public void setLayers(Layer[] layers)
    {
        JObjectArray array = new JObjectArray(layers);
        getJSObject().setProperty("layers", array.getJSObject());
    }


}
