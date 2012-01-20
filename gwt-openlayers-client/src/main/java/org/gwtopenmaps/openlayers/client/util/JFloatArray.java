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
