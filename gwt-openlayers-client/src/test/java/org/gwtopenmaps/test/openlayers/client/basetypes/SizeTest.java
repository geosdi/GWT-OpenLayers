package org.gwtopenmaps.test.openlayers.client.basetypes;

import org.gwtopenmaps.openlayers.client.Size;
import org.gwtopenmaps.test.openlayers.client.BaseTestCase;


public class SizeTest extends BaseTestCase
{

    public void testSize()
    {
        Size size1 = new Size(1, 2);
        Size size2 = new Size(1, 2);
        assertEquals(size1.getClassName(), "OpenLayers.Size");
        assertEquals(1.0f, size1.getWidth());
        assertEquals(2.0f, size1.getHeight());
        assertTrue(size1.equals(size2));
    }

}
