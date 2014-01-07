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
package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class MultipleFeaturesEvent extends GetFeatureEvent {

    protected MultipleFeaturesEvent(JSObject eventObject) {
        super(eventObject);
    }

    public VectorFeature[] getFeatures() {
        JSObject[] jsArr = getJSObject().getPropertyAsArray("features");
        if (jsArr.length == 0) {
            return null;
        }
        // In some cases the parser seems to produces an array with length=1 but with null as element
        if (jsArr[0] == null) {
            return null;
        }

        VectorFeature[] result = new VectorFeature[jsArr.length];
        for (int i = 0; i < jsArr.length; i++) {
            VectorFeature vf = VectorFeature.narrowToVectorFeature(jsArr[i]);
            result[i] = vf;
        }

        return result;
    }

}
