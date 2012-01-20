package org.gwtopenmaps.openlayers.client.util;

import org.gwtopenmaps.openlayers.client.OpenLayersObjectWrapper;


public class JBoolean extends OpenLayersObjectWrapper
{

    public static JBoolean narrowToBooleanElement(JSObject element)
    {
        return ((element == null) || (!JBooleanImpl.isBoolean(element))) ? null : new JBoolean(element);
    }

    protected JBoolean(JSObject element)
    {
        super(element);
    }

    public JBoolean(boolean bool)
    {
        super(JBooleanImpl.create(bool));
    }

    public boolean toBoolean()
    {
        return JBooleanImpl.toBoolean(getJSObject());
    }
}
