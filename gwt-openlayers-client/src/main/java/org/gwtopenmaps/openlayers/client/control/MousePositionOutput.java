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

import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;


/**
 * See {@link MousePosition}.
 *
 * @author Edwin Commandeur - Atlis EJS
 * @since GWT-OL 0.4
 *
 */
public abstract class MousePositionOutput
{

    /**
     * A MousePositionOutput instance that implements this function can
     * be used to set the output format on a {@link MousePosition} control.
     *
     * @param lonLat - a {@link org.gwtopenmaps.openlayers.client.LonLat} with the longitude/latitude at the mouse position
     * @param map - the {@link org.gwtopenmaps.openlayers.client.Map} to which the control has been added.
     * @return String - the output that is shown by the MousePosition control
     */
    public abstract String format(LonLat lonLat, Map map);

}
