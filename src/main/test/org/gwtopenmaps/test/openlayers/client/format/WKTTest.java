package org.gwtopenmaps.test.openlayers.client.format;

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.format.WKT;
import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.test.openlayers.client.BaseTestCase;

public class WKTTest extends BaseTestCase {

	private VectorFeature vf;
	private String WKT_EXPECTED_POINT="POINT(1 2)";

	public void testWKTwrite(){
		Point p = new Point(1.0,2.0);
		vf = new VectorFeature(p);
		WKT wkt = new WKT();
		assertEquals("OpenLayers.Format.WKT", wkt.getClassName());
		assertEquals(WKT_EXPECTED_POINT, wkt.write(vf));

	}

	public void testWKTread(){

	}
}
