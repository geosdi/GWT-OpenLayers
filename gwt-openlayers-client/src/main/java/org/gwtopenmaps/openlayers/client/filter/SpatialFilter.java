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
package org.gwtopenmaps.openlayers.client.filter;

import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.geometry.Geometry;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * This class represents a spatial filter.
 *
 * @author Frank Wynants
 *
 */
public class SpatialFilter extends Filter {

    public enum Types {

        BBOX, INTERSECTS, DWITHIN, WITHIN, CONTAINS
    };

    protected SpatialFilter(JSObject object) {
        super(object);
    }

    public SpatialFilter() {
        super(SpatialFilterImpl.create());
    }

    public static SpatialFilter narrowToSpatialFilter(JSObject object) {
        return (object == null) ? null : new SpatialFilter(object);
    }

    /**
     * Set the type of this filter. The type should be one of the enum types.
     *
     * @param type Type of spatial filter.
     *
     */
    public void setType(final Types type) {
        final String sType = type.name();
        getJSObject().setProperty("type", sType);
    }

    /**
     * The geometry to be used by the filter. Use bounds for BBOX filters and
     * geometry for INTERSECTS or DWITHIN filters.
     *
     * @param geom OpenLayers.Geometry
     */
    public void setGeometryValue(Geometry geom) {
        getJSObject().setProperty("value", geom.getJSObject());
    }

    /**
     * The bounds to be used by the filter. Use bounds for BBOX filters and
     * geometry for INTERSECTS or DWITHIN filters.
     *
     * @param bounds OpenLayers.Bounds
     */
    public void setBoundsValue(Bounds bounds) {
        getJSObject().setProperty("value", bounds.getJSObject());
    }

    /**
     * The distance to use in a DWithin spatial filter.
     *
     * @param distance The distance to use in a DWithin spatial filter.
     */
    public void setDistance(int distance) {
        getJSObject().setProperty("distance", distance);
    }

    /**
     * The units to use for the distance, e.g. ‘m’.
     *
     * @param distanceUnits The units to use for the distance, e.g. ‘m’.
     */
    public void setDistanceUnits(String distanceUnits) {
        getJSObject().setProperty("distanceUnits", distanceUnits);
    }

}