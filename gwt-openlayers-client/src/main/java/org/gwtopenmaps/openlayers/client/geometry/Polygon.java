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
package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class Polygon extends Collection {

    public static Polygon narrowToPolygon(JSObject polygon) {
        return (polygon == null) ? null : new Polygon(polygon);
    }

    protected Polygon(JSObject element) {
        super(element);
    }

    public Polygon(LinearRing[] rings) {
        this(PolygonImpl.create((new JObjectArray(rings)).getJSObject()));
    }

    /**
     * Polygons are composed of LinearRing geometries. LinearRing geometries are
     * MultiPoint geometries, whose components are Points. The first and last
     * component of a LinearRing is the same point, even if a LinearRing is
     * instantiated with an array of Points whose first and last point are not
     * the same.
     *
     * @return Array of LinearRing Objects
     */
    public LinearRing[] getComponents() {
        int max = getNumberOfComponents();
        LinearRing[] components = new LinearRing[max];
        for (int i = 0; i < max; i++) {
            components[i] = LinearRing.narrowToLinearRing(getComponent(i));
        }

        return components;
    }

    /**
     * Determine if the input geometry intersects this one.
     *
     * @param geometry Any type of geometry.
     * @return The input geometry intersects this one.
     */
    public boolean intersects(Geometry geometry) {
        return PolygonImpl.intersects(getJSObject(), geometry.getJSObject());
    }

    public double getArea() {
        return PolygonImpl.getArea(getJSObject());
    }

    public double getGeodesicArea(Projection projection) {
        return PolygonImpl.getGeodesicArea(getJSObject(),
                projection.getJSObject());
    }

    /**
     * APIMethod: createRegularPolygon Create a regular polygon around a radius.
     * Useful for creating circles and the like.
     *
     * Parameters: origin - {<OpenLayers.Geometry.Point>} center of polygon.
     * radius - {Float} distance to vertex, in map units. sides - {Integer}
     * Number of sides. 20 approximates a circle. rotation - {Float} original
     * angle of rotation, in degrees.
     */
    public static Polygon createRegularPolygon(Point origin, float radius,
            int sides,
            float rotation) {

        return Polygon.narrowToPolygon(PolygonImpl.createRegularPolygon(origin.
                getJSObject(), radius, sides, radius));
    }

}
