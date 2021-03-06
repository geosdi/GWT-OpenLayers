/*
 *
 *   Copyright 2015 GWT OpenLayers Team.
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


public class JDoubleArray extends JArrayBase
{

    public static JDoubleArray narrowToJDoubleArray(JSObject array)
    {
        return new JDoubleArray(array);
    }

    public static JDoubleArray create(double[] doubles)
    {
        JDoubleArray array = JDoubleArray.narrowToJDoubleArray(JSObject.createJSArray());
        for (int i = 0, max = doubles.length; i < max; i++)
        {
            array.push(doubles[i]);
        }

        return array;
    }

    protected JDoubleArray(JSObject array)
    {
        super(array);
    }

    public double get(int index)
    {
        return JDoubleArrayImpl.get(getJSObject(), index);
    }

    public void push(double d)
    {
        JDoubleArrayImpl.push(getJSObject(), d);
    }

}
