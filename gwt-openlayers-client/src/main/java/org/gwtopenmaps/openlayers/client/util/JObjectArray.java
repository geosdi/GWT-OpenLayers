package org.gwtopenmaps.openlayers.client.util;


/**
 * Wraps a Javascript array that contains "non-basic type" of elements or
 * elements of mixed type. "Basic type" elements are wrapped in the following
 * array classes:
 * <ul>
 *  <li>{@link JIntArray}</li>
 *  <li>{@link JBooleanArray}</li>
 *  <li>{@link JFloatArray}</li>
 *  <li>{@link JDoubleArray}</li>
 *  <li>{@link JStringArray}</li>
 * </ul>
 */
public class JObjectArray extends JArrayBase
{

    public static JObjectArray narrowToJObjectArray(JSObject element)
    {
        return (element == null) ? null : new JObjectArray(element);
    }

    protected JObjectArray(JSObject element)
    {
        super(element);
    }

    public JObjectArray(JSObject[] array)
    {
        super(array.length);

        for (int i = 0; i < array.length; i++)
        {
            set(i, array[i]);
        }
    }

    public JObjectArray(JSObjectWrapper[] array)
    {
        super(array.length);

        for (int i = 0; i < array.length; i++)
        {
            set(i, array[i].getJSObject());
        }
    }

    public void set(int index, JSObject value)
    {
        JObjectArrayImpl.arraySet(getJSObject(), index, value);
    }

    public JSObject get(int index)
    {
        return JObjectArrayImpl.getAsJSObject(getJSObject(), index);
    }

    public JSObject[] toArray()
    {
        JSObject[] rtn = new JSObject[length()];

        for (int i = 0; i < rtn.length; i++)
        {
            if (JObjectArrayImpl.isNumber(getJSObject(), i))
            {
                rtn[i] = JObjectArrayImpl.getNumberAsJSObject(getJSObject(), i);
            }
            else if (JObjectArrayImpl.isBoolean(getJSObject(), i))
            {
                rtn[i] = JObjectArrayImpl.getBooleanAsJSObject(getJSObject(), i);
            }
            else
            {
                rtn[i] = JObjectArrayImpl.getAsJSObject(getJSObject(), i);
            }
        }

        return rtn;
    }

}
