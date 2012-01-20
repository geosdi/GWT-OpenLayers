package org.gwtopenmaps.test.openlayers.client.util;

import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.test.openlayers.client.BaseTestCase;


public class JSObjectTest extends BaseTestCase
{

    public void testJSObject()
    {
        JSObject object = JSObject.createJSObject();
        object.setProperty("testInt", 1);
        assertEquals(1, object.getPropertyAsInt("testInt"));
        object.setProperty("testFloat", 1.0f);
        assertEquals(1.0f, object.getPropertyAsFloat("testFloat"));
        object.setProperty("testDouble", 1.0);
        assertEquals(1.0, object.getPropertyAsDouble("testDouble"));
        object.setProperty("testBoolean", false);
        assertEquals(false, object.getPropertyAsBoolean("testBoolean"));
        object.setProperty("testString", "test");
        assertEquals("test", object.getPropertyAsString("testString"));
        assertEquals("testInt,testFloat,testDouble,testBoolean,testString",
            object.getPropertyNames());
    }

}
