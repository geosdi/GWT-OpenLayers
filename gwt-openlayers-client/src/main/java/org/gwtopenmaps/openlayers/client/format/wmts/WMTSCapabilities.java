/**
 *
 * Copyright 2014 sourceforge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.gwtopenmaps.openlayers.client.format.wmts;

import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.layer.WMTS;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Zsolt Sandor
 */
public class WMTSCapabilities extends OpenLayersObjectWrapper {

    private WMTSCapabilitiesOptions wmtsCapabilitiesOptions;

    protected WMTSCapabilities(JSObject element) {
        super(element);
    }

    public WMTSCapabilities() {
        this(WMTSCapabilitiesImpl.create());
    }

    public WMTSCapabilities(WMTSCapabilitiesOptions wmtsCapabilitiesOptions) {
        this(WMTSCapabilitiesImpl.create(wmtsCapabilitiesOptions.getJSObject()));
        this.wmtsCapabilitiesOptions = wmtsCapabilitiesOptions;
    }

    public WMTSCapabilitiesOptions getWMTSCapabilitiesOptions() {
        return wmtsCapabilitiesOptions = ((this.wmtsCapabilitiesOptions != null)
                ? this.wmtsCapabilitiesOptions : new WMTSCapabilitiesOptions());
    }

    public void setYX(JSObject object) {
        getJSObject().setProperty("yx", object);
    }

    public JSObject getYX() {
        return getJSObject().getProperty("yx");
    }

    public void setDefaultVersion(String version) {
        getJSObject().setProperty("defaultVersion", version);
    }

    public String getDefaultVersion() {
        return getJSObject().getPropertyAsString("defaultVersion");
    }

    public JSObject read(String data) {
        return WMTSCapabilitiesImpl.read(getJSObject(), data);
    }

    /**
     * This method creates a wmts layer from the given capabilities
     *
     * @param capabilities capabilities object returned by read()
     * @param options additional options
     * @return wmts layer
     */
    public Layer createLayer(JSObject capabilities, WMTSCapabilitiesConfig options) {
        JSObject result = WMTSCapabilitiesImpl.createLayer(getJSObject(), capabilities, options.getJSObject());
        return WMTS.narrowToLayer(result);
    }

    public static WMTSCapabilities narrowToWMTSCapabilities(JSObject element) {
        return (element == null) ? null : new WMTSCapabilities(element);
    }

}
