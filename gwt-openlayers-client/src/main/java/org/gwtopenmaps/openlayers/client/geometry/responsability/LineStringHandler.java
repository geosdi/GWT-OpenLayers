/*
 * Copyright 2014 geoSDI.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gwtopenmaps.openlayers.client.geometry.responsability;

import org.gwtopenmaps.openlayers.client.geometry.Geometry;
import org.gwtopenmaps.openlayers.client.geometry.LineString;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
class LineStringHandler extends GWTOLGeometryHandler {

    public LineStringHandler() {
        super.setSuccessor(new MultiLineStringHandler());
    }

    @Override
    public Geometry buildGeometry(String geomClassName, JSObject geomElement)
            throws IllegalStateException {

        return (isCompatibleGeometry(geomClassName)
                ? LineString.narrowToLineString(geomElement)
                : super.forwardBuildGeometry(geomClassName, geomElement));
    }

    @Override
    protected boolean isCompatibleGeometry(String geomClassName) {
        return geomClassName.equals(Geometry.LINESTRING_CLASS_NAME);
    }

}
