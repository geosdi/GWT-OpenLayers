package org.gwtopenmaps.openlayers.client.layer;

public class VirtualEarthOption extends EventPaneOptions
{

    public void setType(String type)
    {
        getJSObject().setProperty("type", type);
    }

    public void setSphericalMercator(boolean value)
    {
        getJSObject().setProperty("sphericalMercator", value);
    }

    public void setWrapDateLine(boolean wrapDateLine)
    {
        getJSObject().setProperty("wrapDateLine", wrapDateLine);
    }

    public void setAnimationEnabled(boolean animationEnabled)
    {
        getJSObject().setProperty("animationEnabled", true);
    }
}
