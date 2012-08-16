package org.gwtopenmaps.openlayers.client.control;


/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class NavigationOptions extends ControlOptions
{

    public void setZoomWheelEnabled(boolean zoomWheelEnabled)
    {
        getJSObject().setProperty("zoomWheelEnabled", zoomWheelEnabled);
    }

    public void setHandleRightClicks(boolean handleRightClicks)
    {
        getJSObject().setProperty("handleRightClicks", handleRightClicks);
    }

    /**
     *
     * @param zoomBoxKeyMask - by default ... (shift)
     */
    public void setZoomBoxKeyMask(int zoomBoxKeyMask)
    {
        getJSObject().setProperty("zoomBoxKeyMask", zoomBoxKeyMask);
    }
    
    /**
     * Set options passed to the DragPan control
     * @param dragPanOptions 
     */
    public void setDragPanOptions(DragPanOptions dragPanOptions)
    {
        getJSObject().setProperty("dragPanOptions", dragPanOptions.getJSObject());
    }
    
    /**
     * Set options passed to the PinchZoom control
     * @param pinchZoomOptions 
     */
    public void setPinchZoomOptions(PinchZoomOptions pinchZoomOptions)
    {
        getJSObject().setProperty("pinchZoomOptions", pinchZoomOptions.getJSObject());
    }
}
