package org.gwtopenmaps.test.openlayers.client.basetypes;

import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.test.openlayers.client.BaseTestCase;


public class BoundsTest extends BaseTestCase
{

    public void testBounds() {
        Bounds bounds = new Bounds(0, 0, 4, 4);
        assertEquals("OpenLayers.Bounds", bounds.getClassName());

        // assertEquals(new LonLat(2,2),bounds.getCenterLonLat());
        LonLat center = bounds.getCenterLonLat();
        center.getClassName();
    }

}
