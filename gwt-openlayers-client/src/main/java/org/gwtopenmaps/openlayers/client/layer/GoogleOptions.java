package org.gwtopenmaps.openlayers.client.layer;


/**
 * @author Aaron Novstrup - Stottler Henke Associates, Inc.
 *
 */
public class GoogleOptions extends EventPaneOptions
{

    public void setType(GMapType type)
    {
        getJSObject().setProperty("type", type.getJSObject());
    }

    public void setSphericalMercator(boolean value)
    {
        getJSObject().setProperty("sphericalMercator", value);
    }
}
