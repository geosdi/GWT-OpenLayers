/*
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

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
class OpenLayerCreatorStore extends LayerCreatorStore {

    @Override
    protected void registerLayerCreator(Layer layer) {
        if (layer == null) {
            throw new IllegalArgumentException("The Layer cannot be null.");
        }

        String layerClassName = layer.getJSObject().getPropertyAsString(
                "CLASS_NAME");
        if (!super.isLayerCreatorRegisterd(layerClassName)) {
            registar.put(layerClassName, layer.getLayerCreator());
        }
    }

    @Override
    protected <L extends Layer> L createLayer(JSObject jsObject) {
        if (jsObject == null) {
            throw new IllegalArgumentException("The JSObject cannot be null.");
        }

        Layer.LayerCreator<L> layerCreator = (Layer.LayerCreator<L>) super.getLayerCreator(
                jsObject.getPropertyAsString("CLASS_NAME"));

        return (layerCreator != null) ? layerCreator.createLayer(jsObject) : new Layer.LayerCreator<L>() {

            public L createLayer(JSObject jsObject) {
                return (L) new Layer(jsObject);
            }
        }.createLayer(jsObject);
    }

}
