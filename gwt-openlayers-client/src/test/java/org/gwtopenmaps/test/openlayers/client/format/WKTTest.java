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
