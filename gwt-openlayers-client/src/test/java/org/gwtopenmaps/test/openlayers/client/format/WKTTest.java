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
package org.gwtopenmaps.test.openlayers.client.format;

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.format.WKT;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.test.openlayers.client.BaseTestCase;


public class WKTTest extends BaseTestCase
{

    private VectorFeature vf;
    private final String WKT_POINT = "POINT(1 2)";
//      private final String WKT_LINE="";
//      private final String WKT_POLYGON="";


    public void testWKTwrite()
    {
        Point p = new Point(1.0, 2.0);
        vf = new VectorFeature(p);

        WKT wkt = new WKT();
        assertEquals("OpenLayers.Format.WKT", wkt.getClassName());
        assertEquals(WKT_POINT, wkt.write(vf));

    }

    public void testWKTread()
    {
        WKT wkt = new WKT();
        VectorFeature[] vfs = wkt.read(WKT_POINT);
        assertEquals(1, vfs.length);

        String geometry_class = vfs[0].getGeometry().getClassName();
        assertEquals("OpenLayers.Geometry.Point", geometry_class);
    }
}
