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
/**
 *
 */
package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 *
 */
public class Curve extends MultiPoint {

    public static Curve narrowToCurve(JSObject curve) {
        return (curve == null) ? null : new Curve(curve);
    }

    protected Curve(JSObject element) {
        super(element);
    }

    public Curve(Point[] points) {
        this(CurveImpl.create((new JObjectArray(points)).getJSObject()));
    }

    /**
     * APIMethod: getGeodesicLength Calculate the approximate length of the
     * geometry were it projected onto the earth.
     *
     * projection - {@link Projection} The spatial reference system for the
     * geometry coordinates. If not provided, Geographic/WGS84 is assumed.
     *
     * Returns: {double} The appoximate geodesic length of the geometry in
     * meters.
     */
    public double getGeodesicLength(Projection projection) {
        return (projection != null) ? CurveImpl.getGeodesicLength(getJSObject(),
                projection.getJSObject()) : CurveImpl.getGeodesicLength(
                getJSObject(),
                null);
    }

}
