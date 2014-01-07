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
public class JStringArray extends JArrayBase
{

    public static JStringArray narrowToJStringArray(JSObject element)
    {
        return (element == null) ? null : new JStringArray(element);
    }

    public static JStringArray create(String[] strings)
    {
        JStringArray array = JStringArray.narrowToJStringArray(JSObject.createJSArray());
        for (int i = 0, max = strings.length; i < max; i++)
        {
            array.push(strings[i]);
        }

        return array;
    }

    protected JStringArray(JSObject element)
    {
        super(element);
    }

    public JStringArray(String[] array)
    {
        super(array.length);

        for (int i = 0; i < array.length; i++)
        {
            set(i, array[i]);
        }
    }

    public void set(int index, String value)
    {
        JStringArrayImpl.arraySet(getJSObject(), index, value);
    }

    public String[] toArray()
    {
        String[] rtn = new String[length()];

        for (int i = 0; i < rtn.length; i++)
        {
            rtn[i] = JStringArrayImpl.getAsString(getJSObject(), i);
        }

        return rtn;
    }

    public void push(String s)
    {
        JStringArrayImpl.push(getJSObject(), s);
    }

}
