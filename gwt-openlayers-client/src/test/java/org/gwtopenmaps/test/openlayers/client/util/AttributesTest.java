package org.gwtopenmaps.test.openlayers.client.util;

import org.gwtopenmaps.openlayers.client.util.Attributes;
import org.gwtopenmaps.test.openlayers.client.BaseTestCase;


public class AttributesTest extends BaseTestCase
{

    public void testAttributes()
    {
        Attributes attributes = new Attributes();
        attributes.setAttribute("testInt", 1);
        assertEquals(1, attributes.getAttributeAsInt("testInt"));
        attributes.setAttribute("testFloat", 1.0f);
        assertEquals(1.0f, attributes.getAttributeAsFloat("testFloat"));
        attributes.setAttribute("testDouble", 1.0);
        assertEquals(1.0, attributes.getAttributeAsDouble("testDouble"));
        attributes.setAttribute("testBoolean", false);
        assertEquals(false, attributes.getAttributeAsBoolean("testBoolean"));
        attributes.setAttribute("testString", "test");
        assertEquals("test", attributes.getAttributeAsString("testString"));
    }

}
