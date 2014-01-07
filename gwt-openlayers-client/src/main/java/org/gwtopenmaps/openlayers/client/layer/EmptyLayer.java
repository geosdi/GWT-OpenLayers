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
package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * An empty layer.
 * @author Max Gensthaler
 */

public class EmptyLayer extends Layer {
    protected EmptyLayer(JSObject imageLayer) {
    	super(imageLayer);
    }

    /**
     * Create an empty layer.
     * @param name The name of the layer
     * @param options The options
     */
    public EmptyLayer(String name, Options options) {
    	super(EmptyLayerImpl.create(name, options.getJSObject()));
    }

    private static class EmptyLayerImpl {
    	public static native JSObject create(String name, JSObject params)/*-{
        	return new $wnd.OpenLayers.Layer(name, params);
        }-*/;
    }

    public static class Options extends LayerOptions {
        //
    }
}