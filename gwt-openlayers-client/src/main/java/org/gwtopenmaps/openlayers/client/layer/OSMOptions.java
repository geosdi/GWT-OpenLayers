package org.gwtopenmaps.openlayers.client.layer;

public class OSMOptions extends LayerOptions
{

    public OSMOptions()
    {
        //
    }

    public void setDisplayOutsideMaxExtent(boolean value)
    {
        getJSObject().setProperty("displayOutsideMaxExtent", value);
    }

    public void setWrapDateLine(boolean value)
    {
        getJSObject().setProperty("wrapDateLine", value);
    }

}
