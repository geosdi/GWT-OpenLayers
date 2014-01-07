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
import org.gwtopenmaps.openlayers.client.util.JStringArray;

/**
 *
 * @author Erdem Gunay Amr Alam - Refractions Research Curtis Jensen
 */
public class WMS extends GridLayer {

    protected WMS(JSObject wms) {
        super(wms);
    }

    public static WMS narrowToWMS(JSObject wms) {
        return (wms == null) ? null : new WMS(wms);
    }

    public WMS(String name,
            String url,
            WMSParams params) {
        this(WMSImpl.create(name, url, params.getJSObject()));
    }

    public WMS(String name,
            String url,
            WMSParams params,
            WMSOptions layerParams) {
        this(WMSImpl.create(name, url, params.getJSObject(),
                            layerParams.getJSObject()));
    }

    public WMS(String name,
            String[] urls,
            WMSParams params) {
        this(WMSImpl.create(name, new JStringArray(urls).getJSObject(),
                            params.getJSObject()));
    }

    public WMS(String name,
            String[] urls,
            WMSParams params,
            WMSOptions layerParams) {
        this(WMSImpl.create(name, new JStringArray(urls).getJSObject(),
                            params.getJSObject(), layerParams.getJSObject()));
    }

    public int getNumLoadingTiles() {
        return WMSImpl.getNumLoadingTiles(getJSObject());
    }

    public WMSParams getParams() {
        JSObject params = HTTPRequestLayerImpl.getParams(getJSObject());
        return new WMSParams(params);
    }

    public WMSOptions getOptions() {
        JSObject options = LayerImpl.getOptions(getJSObject());
        return new WMSOptions(options);
    }
}
