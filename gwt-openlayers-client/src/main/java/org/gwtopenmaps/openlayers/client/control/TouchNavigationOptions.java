package org.gwtopenmaps.openlayers.client.control;


/**
 * @author Jon Britton - SpiffyMap Ltd
 */
public class TouchNavigationOptions extends ControlOptions
{

    public void setDragPanOptions(DragPanOptions dragPanOptions)
    {
        getJSObject().setProperty("dragPanOptions", dragPanOptions.getJSObject());
    }
    
    public void setPinchZoomOptions(PinchZoomOptions pinchZoomOptions)
    {
        getJSObject().setProperty("pinchZoomOptions", pinchZoomOptions.getJSObject());
    }

}
