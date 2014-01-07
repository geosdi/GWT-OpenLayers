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
package org.gwtopenmaps.openlayers.client.util;


/**
 * Base class for classes wrapping Javascript arrays.
 *
 * Get and set methods are implemented in subclasses, to make sure
 * they get and set the correct type of array element.
 *
 */
public class JArrayBase extends JSObjectWrapper
{

    public static JArrayBase narrowToJArray(JSObject element)
    {
        return (element == null) ? null : new JArrayBase(element);
    }

    protected JArrayBase(JSObject element)
    {
        super(element);
    }

    protected JArrayBase(int length)
    {
        this(JArrayBaseImpl.create(length));
    }

    public int length()
    {
        return JArrayBaseImpl.arrayLength(getJSObject());
    }
}
