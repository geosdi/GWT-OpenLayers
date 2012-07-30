package org.gwtopenmaps.openlayers.client.control;


/**
 * @author Jon Britton
 *
 */
public class TouchNavigationOptions extends ControlOptions
{

    public void setDragPanOptions(DragPanOptions dragPanOptions)
    {
        getJSObject().setProperty("dragPanOptions", dragPanOptions.getJSObject());
    }

}
