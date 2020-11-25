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
package org.gwtopenmaps.openlayers.client.format.wmts;

import org.gwtopenmaps.openlayers.client.OpenLayersEObjectWrapper;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Zsolt Sandor
 */
public class WMTSCapabilitiesConfig extends OpenLayersEObjectWrapper {

    protected WMTSCapabilitiesConfig(JSObject jsObject) {
        super(jsObject);
    }

    public WMTSCapabilitiesConfig() {
        this(JSObject.createJSObject());
    }

    public void setLayer(String value) {
        getJSObject().setProperty("layer", value);
    }

    public String getLayer() {
        return getJSObject().getPropertyAsString("layer");
    }

    public void setMatrixSet(String value) {
        getJSObject().setProperty("matrixSet", value);
    }

    public String getMatrixSet() {
        return getJSObject().getPropertyAsString("matrixSet");
    }

    public void setProjection(String value) {
        getJSObject().setProperty("projection", value);
    }

    public String getProjection() {
        return getJSObject().getPropertyAsString("projection");
    }

    public void setStyle(String value) {
        getJSObject().setProperty("style", value);
    }

    public String getStyle() {
        return getJSObject().getPropertyAsString("style");
    }

    public void setFormat(String value) {
        getJSObject().setProperty("format", value);
    }

    public String getFormat() {
        return getJSObject().getPropertyAsString("format");
    }

    public void setParam(JSObject value) {
        getJSObject().setProperty("param", value);
    }

    public JSObject getParam() {
        return getJSObject().getProperty("param");
    }

}
