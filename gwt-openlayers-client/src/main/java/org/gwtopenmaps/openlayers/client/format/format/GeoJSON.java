/**
 * Copyright 2015 sourceforge.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gwtopenmaps.openlayers.client.format.format;

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

import static java.lang.Boolean.FALSE;

/**
 * Brief explanation of GeoJSON vector format here.
 * <p>
 * Reference to GeoJSON specification.
 *
 * @author Edwin Commandeur - Atlis EJS
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 */
public class GeoJSON extends VectorFormat {

    protected GeoJSON(JSObject geoJSONFormat) {
        super(geoJSONFormat);
    }

    public GeoJSON() {
        this(GeoJSONImpl.create());
    }

    /**
     * @param obj    <p>{Object} An {@link VectorFeature}, {@link org.gwtopenmaps.openlayers.client.geometry.Geometry}, or an array of {@link VectorFeature}.</p>
     * @param pretty <p>{Boolean} Structure the output with newlines and indentation.  Default is false.</p>
     * @return {@link String} <p>The GeoJSON string representation of the input geometry, features, or array of features.</p>
     */
    public String write(JSObjectWrapper obj, Boolean pretty) {
        return GeoJSONImpl.write(getJSObject(), obj.getJSObject(), ((pretty != null) ? pretty : FALSE));
    }
}
