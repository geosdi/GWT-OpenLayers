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
package org.gwtopenmaps.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.util.JObjectArray;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * MultiPoint is a collection of Points.
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 *
 */
public class MultiPoint extends Collection {

    public static MultiPoint narrowToMultiPoint(JSObject multiPoint) {
        return (multiPoint == null) ? null : new MultiPoint(multiPoint);
    }

    protected MultiPoint(JSObject element) {
        super(element);
    }

    public MultiPoint(Point[] points) {
        this(MultiPointImpl.create((new JObjectArray(points)).getJSObject()));
    }

    public Point[] getComponents() {
        int max = getNumberOfComponents();
        Point[] components = new Point[max];
        for (int i = 0; i < max; i++) {
            components[i] = Point.narrowToPoint(getComponent(i));
        }

        return components;
    }

    public double[][] getCoordinateArray() {
        Point[] components = getComponents();
        int max = components.length;
        double[][] coordinateArray = new double[max][];
        for (int i = 0; i < max; i++) {
            coordinateArray[i] = components[i].getXY();
        }

        return coordinateArray;
    }

    /**
     * Add a point to the MultiPoint
     *
     * @param point The point to add
     * @param The index
     */
    public void addPoint(Point point, int index) {
        addComponent(point, index);
    }

    /**
     * Removes a point from this MultiPoint
     *
     * @param point The point to remove
     */
    public void removePoint(Point point) {
        removeComponent(point);
    }

}
