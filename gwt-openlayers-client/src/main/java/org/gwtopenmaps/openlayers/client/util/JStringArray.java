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
