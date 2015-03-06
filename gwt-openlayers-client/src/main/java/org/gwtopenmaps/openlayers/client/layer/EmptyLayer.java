/**
 *
 *   Copyright 2015 sourceforge.
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
 * An empty layer.
 *
 * @author Max Gensthaler
 */
public class EmptyLayer extends Layer {

    public static final String EMPTY_LAYER_CLASS_NAME = "OpenLayers.Layer.EmptyLayer";

    protected EmptyLayer(JSObject imageLayer) {
        super(imageLayer);
    }

    /**
     * Create an empty layer.
     *
     * @param name The name of the layer
     * @param options The options
     */
    public EmptyLayer(String name, Options options) {
        this(EmptyLayerImpl.create(name, options.getJSObject(),
                EMPTY_LAYER_CLASS_NAME));
    }

    private static class EmptyLayerImpl {

        public static native JSObject create(String name, JSObject params,
                String className)/*-{
         var l = new $wnd.OpenLayers.Layer(name, params);
         l.CLASS_NAME=className;
         return l;
         }-*/;
    }

    public static class Options extends LayerOptions {
        //
    }

    @Override
    protected LayerCreator<EmptyLayer> getLayerCreator() {
        return new LayerCreator<EmptyLayer>() {

            public EmptyLayer createLayer(JSObject jsObject) {
                return new EmptyLayer(jsObject);
            }
        };
    }

}
