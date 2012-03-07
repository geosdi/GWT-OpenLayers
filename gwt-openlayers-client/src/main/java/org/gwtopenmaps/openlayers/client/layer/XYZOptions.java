package org.gwtopenmaps.openlayers.client.layer;

/**
 * @author Edwin Commandeur - Atlis EJS
 * @author Curtis Jensen
 */
public class XYZOptions extends GridLayerOptions
{

    /**
     *
     * @param b
     */
    public void setSphericalMercator(boolean b)
    {
        getJSObject().setProperty("sphericalMercator", b);
    }

    /**
     *
     * @param zoomOffset
     */
    public void setZoomOffset(int zoomOffset)
    {
        getJSObject().setProperty("zoomOffset", zoomOffset);
    }

    /**
    *
    * @param b
    */
    public void setIsBaseLayer(boolean b)
    {
        getJSObject().setProperty("isBaseLayer", b);
    }

}
