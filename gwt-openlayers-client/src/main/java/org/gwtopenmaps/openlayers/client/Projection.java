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
package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JSObjectWrapper;

/**
 * From the OpenLayers API docs:
 * Class for coordinate transforms between coordinate systems.
 *
 * @author Evgeny Gazdovsky
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class Projection extends JSObjectWrapper {

    protected Projection(JSObject element) {
        super(element);
    }

    /**
     *
     * @param projectionCode - projection code that identifies the projection or
     * an SRS in a
     * repository that contains projection and SRS definitions, such as the EPSG
     * registry.
     * An example of an EPSG SRS code is EPSG:4326, which is typically projected
     * in equidistant
     * cylindrical projection.
     */
    public Projection(String projectionCode) {
        this(ProjectionImpl.create(projectionCode));
    }

    /**
     *
     * @return String - projection code, see {@link #Projection(String)}.
     */
    public String getProjectionCode() {
        return ProjectionImpl.getProjectionCode(getJSObject());
    }

    public static Projection narrowToProjection(JSObject projection) {
        return new Projection(projection);
    }
}
