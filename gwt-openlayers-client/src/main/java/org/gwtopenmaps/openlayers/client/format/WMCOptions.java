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
package org.gwtopenmaps.openlayers.client.format;

import org.gwtopenmaps.openlayers.client.Map;


public class WMCOptions extends FormatOptions
{

    // TODO: create constructors that take map or id

    /**
     * Use this method to merge ... with the map
     * or
     * use setMapDomElementId to create a new map in that dom element.
     *
     *
     * @param map - the map to merge map elements with that are created
     *   on the basis of the WMC document
     */
    public void setMap(Map map)
    {
        getJSObject().setProperty("map", map.getJSObject());
    }

    /**
     *
     * @param id - the dom element id where to put the map created
     *   from reading a WMC document
     */
    public void setMapDomElementId(String id)
    {
        getJSObject().setProperty("map", id);
    }
}
