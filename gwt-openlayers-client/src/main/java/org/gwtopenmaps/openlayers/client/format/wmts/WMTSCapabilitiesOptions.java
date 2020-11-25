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
package org.gwtopenmaps.openlayers.client.format.wmts;

import org.gwtopenmaps.openlayers.client.OpenLayersEObjectWrapper;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Zsolt Sandor
 */
public class WMTSCapabilitiesOptions extends OpenLayersEObjectWrapper {

    protected WMTSCapabilitiesOptions(JSObject jsObject) {
        super(jsObject);
    }

    public WMTSCapabilitiesOptions() {
        this(JSObject.createJSObject());
    }

    public void setYX(YXOptions object) {
        getJSObject().setProperty("yx", object.getJSObject());
    }

    public YXOptions getYX() {
        return YXOptions.narrowToYXOptions(getJSObject().getProperty("yx"));
    }

    public void setDefaultVersion(String version) {
        getJSObject().setProperty("defaultVersion", version);
    }

    public String getDefaultVersion() {
        return getJSObject().getPropertyAsString("defaultVersion");
    }

}
