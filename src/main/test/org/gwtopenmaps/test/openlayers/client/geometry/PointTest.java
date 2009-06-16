package org.gwtopenmaps.test.openlayers.client.geometry;

import org.gwtopenmaps.openlayers.client.geometry.Point;
import org.gwtopenmaps.test.openlayers.client.BaseTestCase;

public class PointTest extends BaseTestCase {

	private Point p;

	public void testPoint(){
		p = new Point(1.0, 2.0);
		assertEquals(1.0, p.getX());
		assertEquals(2.0, p.getY());
		//System.out.println("point X: " + p.getX());
	}

}
