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
 *
 *
 */
public class JIntArray extends JArrayBase
{

    public static JIntArray narrowToJIntArray(JSObject element)
    {
        return (element == null) ? null : new JIntArray(element);
    }

    public static JIntArray create(int[] integers)
    {
        JIntArray array = JIntArray.narrowToJIntArray(JSObject.createJSArray());
        for (int i = 0, max = integers.length; i < max; i++)
        {
            array.push(integers[i]);
        }

        return array;
    }

    protected JIntArray(JSObject element)
    {
        super(element);
    }

    public JIntArray(int[] array)
    {
        super(array.length);

        for (int i = 0; i < array.length; i++)
        {
            set(i, array[i]);
        }
    }

    public void set(int index, int value)
    {
        JIntArrayImpl.arraySet(getJSObject(), index, value);
    }

    public int[] toArray()
    {
        int[] rtn = new int[length()];

        for (int i = 0; i < rtn.length; i++)
        {
            rtn[i] = JIntArrayImpl.getAsInt(getJSObject(), i);
        }

        return rtn;
    }

    public void push(int i)
    {
        JIntArrayImpl.push(getJSObject(), i);
    }
}
