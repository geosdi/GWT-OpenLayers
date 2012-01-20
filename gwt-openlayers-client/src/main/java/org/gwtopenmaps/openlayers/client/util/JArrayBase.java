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
