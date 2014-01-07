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
package org.gwtopenmaps.test.openlayers.client.format;

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.format.KML;
import org.gwtopenmaps.openlayers.client.geometry.Geometry;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.test.openlayers.client.BaseTestCase;


public class KMLTest extends BaseTestCase
{

    private String KML_EXPECTED_POINT = "<Point><coordinates>1,2</coordinates></Point>";
    private String KML_EXPORTED_POINT =
        "<kml xmlns=\"http://earth.google.com/kml/2.0\"><Folder><name>OpenLayers export</name><description>Exported on Thu Mar 12 18:09:31 UTC+0100 2009</description><Placemark><name>OpenLayers.Feature.Vector_6</name><description>No description available</description><Point><coordinates>1,2</coordinates></Point></Placemark></Folder></kml>";


    public void testKMLwrite()
    {
        Point p = new Point(1.0, 2.0);
        VectorFeature vf = new VectorFeature(p);
        KML kml = new KML();
        assertTrue(kml.write(vf).contains(KML_EXPECTED_POINT));
    }

    public void testKMLread()
    {
        KML kml = new KML();
        VectorFeature[] vf = kml.read(KML_EXPORTED_POINT);
        vf.toString();

        Geometry g = vf[0].getGeometry();
        ;
        assertEquals(Geometry.POINT_CLASS_NAME, g.getClassName());

        // sequence from unknown geometry type to specific geometry type:
        // 1. narrowToGeometry, 2. ask for class, 3. then narrow to appropriate class
        Point p = Point.narrowToPoint(g.getJSObject());
        assertEquals(1.0, p.getX());

    }
}
