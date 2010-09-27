package org.gwtopenmaps.test.openlayers.client;


import junit.framework.Test;
import junit.framework.TestSuite;

import org.gwtopenmaps.test.openlayers.client.basetypes.BoundsTest;
import org.gwtopenmaps.test.openlayers.client.basetypes.SizeTest;
import org.gwtopenmaps.test.openlayers.client.format.KMLTest;
import org.gwtopenmaps.test.openlayers.client.format.WKTTest;
import org.gwtopenmaps.test.openlayers.client.geometry.PointTest;
import org.gwtopenmaps.test.openlayers.client.map.MapOptionsTest;
import org.gwtopenmaps.test.openlayers.client.util.AttributesTest;
import org.gwtopenmaps.test.openlayers.client.util.JSObjectTest;

import com.google.gwt.junit.tools.GWTTestSuite;

public class GwtOpenLayersTestSuite extends GWTTestSuite {

	//TODO, see if the suite can run other suites
	public static Test suite(){
		TestSuite suite = new TestSuite("Tests for GWT-OpenLayers");

		//Tests for Base types
		suite.addTestSuite(SizeTest.class);
		suite.addTestSuite(BoundsTest.class);

		//Tests for Formats
		suite.addTestSuite(WKTTest.class);
		suite.addTestSuite(KMLTest.class);

		//Tests for Geometry
		suite.addTestSuite(PointTest.class);

		//Tests for Util
		suite.addTestSuite(MapOptionsTest.class);
		suite.addTestSuite(AttributesTest.class);

		//Tests for Util
		suite.addTestSuite(JSObjectTest.class);

		//RETURN
		return suite;
	}
}
