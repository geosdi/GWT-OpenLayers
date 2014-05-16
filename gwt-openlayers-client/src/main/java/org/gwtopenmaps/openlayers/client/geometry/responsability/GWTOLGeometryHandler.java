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
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
abstract class GWTOLGeometryHandler {

    protected GWTOLGeometryHandler successor;

    public abstract Geometry buildGeometry(String geomClassName,
            JSObject geomElement) throws IllegalStateException;

    protected Geometry forwardBuildGeometry(String geomClassName,
            JSObject geomElement) throws IllegalStateException {
        if (successor != null) {
            return successor.buildGeometry(geomClassName, geomElement);
        }

        throw new IllegalStateException("There are no Rings in this Chain "
                + "to build Geometry : " + geomClassName);
    }

    protected abstract boolean isCompatibleGeometry(String geomClassName);

    /**
     * @param successor the successor to set
     */
    public void setSuccessor(GWTOLGeometryHandler successor) {
        this.successor = successor;
    }

}
