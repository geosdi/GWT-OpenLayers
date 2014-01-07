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
 * For incoming Arrays it is also possible to
 * use JsArrayNumber that is default in GWT.
 *
 * Note: All native JavaScript numeric values are implicitly double-precision (see JavaDoc JsArrayNumber), so working with floats seems redundant.
 *
 */
public class JFloatArray extends JArrayBase
{

    public static JFloatArray narrowToJFloatArray(JSObject array)
    {
        return new JFloatArray(array);
    }

    public static JFloatArray create(float[] floats)
    {
        JFloatArray array = JFloatArray.narrowToJFloatArray(JSObject.createJSArray());
        for (int i = 0, max = floats.length; i < max; i++)
        {
            array.push(floats[i]);
        }

        return array;
    }

    protected JFloatArray(JSObject array)
    {
        super(array);
    }

    public float get(int index)
    {
        return JFloatArrayImpl.get(getJSObject(), index);
    }

    public float[] toArray()
    {
        float[] rtn = new float[length()];
        for (int i = 0; i < rtn.length; i++)
        {
            rtn[i] = JFloatArrayImpl.getAsFloat(getJSObject(), i);
        }

        return rtn;
    }

    public void push(float f)
    {
        JFloatArrayImpl.push(getJSObject(), f);
    }

}
