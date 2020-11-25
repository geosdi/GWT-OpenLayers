/**
 *
 *   Copyright 2015 GWT OpenLayers Team.
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


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class LayerSwitcherOptions extends ControlOptions
{


    /**
     *
     * @param ascending - true to show layers in ascending alphabetical order
     */
    public void setAscending(boolean ascending)
    {
        getJSObject().setProperty("ascending", ascending);
    }

}
