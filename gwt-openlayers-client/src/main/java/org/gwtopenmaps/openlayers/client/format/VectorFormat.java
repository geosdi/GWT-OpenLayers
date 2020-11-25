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
package org.gwtopenmaps.openlayers.client.format;

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * Format objects provide support for reading and writing formats for
 * representing vector features (or their geometries).
 *
 * There are different standard formats for representing vector features. For
 * example, WKT GML, and KML.
 *
 * A format object can read and write vector features in a specific format.
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class VectorFormat extends Format<VectorFeature[], String> {

    protected VectorFormat(JSObject element) {
        super(element);
    }

    /**
     * Write an array of
     * {@link VectorFeature} objects
     * in a particular format that depends on the specific format object.
     *
     * For example, a WKT format object writes the features in Well Known Text
     * format:      <code>
     *   WKT wktFormat = new WKT();
     *   String wkt = wktFormat.write(vectorFeatures);
     * </code>
     *
     * @param vectorFeatures - an array of vector features
     * @return a String containing the vector features written in a particular
     * format.
     */
    public String write(VectorFeature[] vectorFeatures) {
        JObjectArray objectArray = new JObjectArray(vectorFeatures);

        return FormatImpl.writeArray(getJSObject(), objectArray.getJSObject());
    }

    /**
     * Write a {@link VectorFeature}
     * in a particular format that depends on the specific format object.
     *
     * For example, a WKT format object writes the features in Well Known Text
     * format:      <code>
     *   WKT wktFormat = new WKT();
     *   String wkt = wktFormat.write(vectorFeatures);
     * </code>
     *
     * @param vectorFeature - a vector feature
     * @return a String containing the vector feature written in a particular
     * format.
     */
    public String write(VectorFeature vectorFeature) {
        return FormatImpl.write(getJSObject(), vectorFeature.getJSObject());
    }

    /**
     * Read a String representation of a vector format into an array of vector
     * features.
     *
     * @param vectorFormatString - String of a particular vector format
     * @return array of vector features
     */
    // For VectorFormats with specific read options or different return types
    // specific read functions should be constructed.
    // For example:
    // read(String vfString, WKTReadOptions options)
    // readToMap(String vfString, WKTReadOptions options)
    public VectorFeature[] read(String vectorFormatString) {
        JSObject out = FormatImpl.read(getJSObject(), vectorFormatString);
        JObjectArray jObjectArray = JObjectArray.narrowToJObjectArray(out.ensureOpaqueArray());
        int nr = jObjectArray.length();
        VectorFeature[] vfs = new VectorFeature[nr];
        for (int i = 0; i < nr; i++) {
            // get objects and narrow them to vector features
            vfs[i] = VectorFeature.narrowToVectorFeature(jObjectArray.get(i));
        }

        return vfs;
    }

}
