/**
 *
 * Copyright 2014 sourceforge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.gwtopenmaps.test.openlayers.client.geometry;

import static junit.framework.TestCase.assertEquals;
import org.gwtopenmaps.openlayers.client.geometry.Geometry;
import org.gwtopenmaps.openlayers.client.geometry.LineString;
import org.gwtopenmaps.openlayers.client.geometry.LinearRing;
import org.gwtopenmaps.openlayers.client.geometry.MultiLineString;
import org.gwtopenmaps.openlayers.client.geometry.MultiPoint;
import org.gwtopenmaps.openlayers.client.geometry.MultiPolygon;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.openlayers.client.geometry.Polygon;
import org.gwtopenmaps.test.openlayers.client.BaseTestCase;

public class GeometryTest extends BaseTestCase {

    public void testPoint() {
        Point p = new Point(1.0, 2.0);
        assertEquals(1.0, p.getX());
        assertEquals(2.0, p.getY());
        // System.out.println("point X: " + p.getX());

        Geometry theGeom = Geometry.narrowToGeometry(p.getJSObject());
        assertEquals(true, (theGeom instanceof Point));
    }

    public void testMultiPoint() {
        MultiPoint mp = new MultiPoint(new Point[]{new Point(30, 45),
            new Point(35, 50)});
        assertEquals(2, mp.getNumberOfComponents());

        Geometry theGeom = Geometry.narrowToGeometry(mp.getJSObject());
        assertEquals(true, (theGeom instanceof MultiPoint));
    }

    public void testLineString() {
        LineString ls = new LineString(new Point[]{new Point(30, 45),
            new Point(35, 50)});

        assertEquals(2, ls.getNumberOfComponents());

        Geometry theGeom = Geometry.narrowToGeometry(ls.getJSObject());

        assertEquals(true, (theGeom instanceof LineString));
    }

    public void testMultiLineString() {
        MultiLineString mls = new MultiLineString(new LineString[]{new LineString(new Point[]{new Point(30, 45),
            new Point(35, 50)})});

        assertEquals(1, mls.getNumberOfComponents());

        Geometry theGeom = Geometry.narrowToGeometry(mls.getJSObject());
        assertEquals(true, (theGeom instanceof MultiLineString));
    }

    public void testLinearRing() {
        LinearRing lr = new LinearRing(new Point[]{new Point(30, 45),
            new Point(35, 50)});
        assertEquals(3, lr.getNumberOfComponents());

        Geometry theGeom = Geometry.narrowToGeometry(lr.getJSObject());
        assertEquals(true, (theGeom instanceof LinearRing));
    }

    public void testPolygon() {
        Polygon p = new Polygon(new LinearRing[]{new LinearRing(new Point[]{new Point(30, 45),
            new Point(35, 50)})});
        assertEquals(1, p.getNumberOfComponents());

        Geometry theGeom = Geometry.narrowToGeometry(p.getJSObject());
        assertEquals(true, (theGeom instanceof Polygon));
    }

    public void testMultiPolygon() {
        MultiPolygon mp = new MultiPolygon(new Polygon[]{new Polygon(new LinearRing[]{new LinearRing(new Point[]{new Point(30, 45),
            new Point(35, 50)})})});
        assertEquals(1, mp.getNumberOfComponents());

        Geometry theGeom = Geometry.narrowToGeometry(mp.getJSObject());
        assertEquals(true, (theGeom instanceof MultiPolygon));
    }

}
