package org.gwtopenmaps.openlayers.client.layer;

public class OSMOptions extends XYZOptions
{

    public OSMOptions()
    {
        //
    }

    public void setWrapDateLine(boolean value)
    {
        getJSObject().setProperty("wrapDateLine", value);
    }

}
