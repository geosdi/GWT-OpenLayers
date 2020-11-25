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

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JStringArray;

/**
 * @author Amr Alam - Refractions Research
 *
 */
public class TMS extends GridLayer {

    protected TMS(JSObject element) {
        super(element);
    }

    public TMS(String name, String url, TMSOptions options) {
        this(TMSImpl.create(name, url, options.getJSObject()));
    }

    public TMS(String name, String[] urls, TMSOptions options) {
        this(TMSImpl.create(name, new JStringArray(urls).getJSObject(),
                options.getJSObject()));
    }

    public int getNumLoadingTiles() {
        return TMSImpl.getNumLoadingTiles(this.getJSObject());
    }

    @Override
    protected LayerCreator<TMS> getLayerCreator() {
        return new LayerCreator<TMS>() {

            public TMS createLayer(JSObject jsObject) {
                return new TMS(jsObject);
            }
        };
    }

}
