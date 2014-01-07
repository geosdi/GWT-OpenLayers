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
