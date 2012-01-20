package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class MarkersOptions extends LayerOptions
{

    protected MarkersOptions(JSObject jsObject)
    {
        super(jsObject);
    }

    public MarkersOptions()
    {
        this(JSObject.createJSObject());
    }

    /**
     *
     * @param maxZoomLevel
     */
    public void setMaxZoomLevel(int maxZoomLevel)
    {
        getJSObject().setProperty("maxZoomLevel", maxZoomLevel);
    }
    // What kind of options has Markers?
}
