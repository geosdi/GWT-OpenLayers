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
