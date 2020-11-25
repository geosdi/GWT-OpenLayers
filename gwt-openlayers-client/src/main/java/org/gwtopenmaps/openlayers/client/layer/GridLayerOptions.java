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
package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.Size;
import org.gwtopenmaps.openlayers.client.tile.TileOptions;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 *
 */
public class GridLayerOptions extends HTTPRequestLayerOptions {

    public GridLayerOptions() {
    }

    protected GridLayerOptions(JSObject jsObject) {
        super(jsObject);
    }

    public final void setTileSize(Size size) {
        getJSObject().setProperty("tileSize", size.getJSObject());
    }

    /**
     * For tiled layers the buffer size can be set.
     *
     * The default buffer is 2.
     */
    public void setBuffer(int buffer) {
        getJSObject().setProperty("buffer", buffer);
    }

    public void setTileOptions(TileOptions value) {
        getJSObject().setProperty("tileOptions", value.getJSObject());
    }
}
