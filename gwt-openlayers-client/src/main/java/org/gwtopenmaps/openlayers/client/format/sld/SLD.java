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
package org.gwtopenmaps.openlayers.client.format.sld;

import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * Brief explanation of Styled Layer Description (SLD) style description here.
 *
 * Reference SLD specification.
 *
 * See http://www.opengeospatial.org/standards/sld
 *
 * @author Zsolt Sandor
 */
public class SLD extends OpenLayersObjectWrapper {

    protected SLD(JSObject element) {
        super(element);
    }

    public SLD() {
        this(SLDImpl.create());
    }

    public SLDResult read(String data) {
        JSObject result = SLDImpl.read(getJSObject(), data);
        return new SLDResult(result);
    }

}
