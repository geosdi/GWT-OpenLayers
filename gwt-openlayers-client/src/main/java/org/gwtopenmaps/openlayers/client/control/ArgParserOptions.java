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

import org.gwtopenmaps.openlayers.client.Projection;

/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Jon Britton - SpiffyMap Ltd.
 */
public class ArgParserOptions extends ControlOptions
{
    /**
     * Projection used when reading the coordinates from the URL, requires proj4js support.
     * 
     * This will reproject the map coordinates from the URL into the map’s projection. If 
     * you are using this functionality, be aware that any permalink which is added to the 
     * map will determine the coordinate type which is read from the URL, which means you 
     * should not add permalinks with different displayProjections to the same map.
     * (from OL docs)
     * @param displayProjection 
     */
    public void setDisplayProjection(Projection displayProjection) {
        getJSObject().setProperty("displayProjection", displayProjection.getJSObject());
    }

}
