package org.gwtopenmaps.openlayers.client.control;


/**
 * @author Jon Britton
 */
public class ZoomOptions extends ControlOptions
{
    
    public void setZoomInText(String zoomInText)
    {
        getJSObject().setProperty("zoomInText", zoomInText);
    }
    
    public void setZoomOutText(String zoomOutText)
    {
        getJSObject().setProperty("zoomOutText", zoomOutText);
    }

}
