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
package org.gwtopenmaps.openlayers.client.format.gml.v2;

import org.gwtopenmaps.openlayers.client.format.gml.Base.Base;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * Properties to be initialized for any GML2 by passing this object to the
 * constructor
 *
 * @author Mikael Couzic
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class GML2Options extends Base {

    protected GML2Options(JSObject jsObject) {
        super(jsObject);
    }

    public GML2Options(String featureNS, String featureType) {
        super(featureNS, featureType);

    }

}
