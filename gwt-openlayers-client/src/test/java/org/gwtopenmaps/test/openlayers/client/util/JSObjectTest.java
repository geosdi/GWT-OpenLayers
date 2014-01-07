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
