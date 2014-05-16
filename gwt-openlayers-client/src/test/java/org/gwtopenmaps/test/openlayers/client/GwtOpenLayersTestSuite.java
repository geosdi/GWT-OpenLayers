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
package org.gwtopenmaps.test.openlayers.client;


import com.google.gwt.junit.tools.GWTTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.gwtopenmaps.test.openlayers.client.strategy.ClusterStrategyTest;
import org.gwtopenmaps.test.openlayers.client.strategy.FixedStrategyTest;
import org.gwtopenmaps.test.openlayers.client.strategy.RefreshStrategyTest;
import org.gwtopenmaps.test.openlayers.client.basetypes.BoundsTest;
import org.gwtopenmaps.test.openlayers.client.basetypes.SizeTest;
import org.gwtopenmaps.test.openlayers.client.format.KMLTest;
import org.gwtopenmaps.test.openlayers.client.format.WKTTest;
import org.gwtopenmaps.test.openlayers.client.geometry.GeometryTest;
import org.gwtopenmaps.test.openlayers.client.map.MapOptionsTest;
import org.gwtopenmaps.test.openlayers.client.util.AttributesTest;
import org.gwtopenmaps.test.openlayers.client.util.JSObjectTest;


public class GwtOpenLayersTestSuite extends GWTTestSuite
{

    // TODO, see if the suite can run other suites
    public static Test suite()
    {
        TestSuite suite = new TestSuite("Tests for GWT-OpenLayers");

        // Tests for Base types
        suite.addTestSuite(SizeTest.class);
        suite.addTestSuite(BoundsTest.class);

        // Tests for Formats
        suite.addTestSuite(WKTTest.class);
        suite.addTestSuite(KMLTest.class);

        // Tests for Geometry
        suite.addTestSuite(GeometryTest.class);

        // Tests for Strategies
        suite.addTestSuite(ClusterStrategyTest.class);
        suite.addTestSuite(FixedStrategyTest.class);
        suite.addTestSuite(RefreshStrategyTest.class);

        // Tests for Util
        suite.addTestSuite(MapOptionsTest.class);
        suite.addTestSuite(AttributesTest.class);

        // Tests for Util
        suite.addTestSuite(JSObjectTest.class);

        // RETURN
        return suite;
    }
}
