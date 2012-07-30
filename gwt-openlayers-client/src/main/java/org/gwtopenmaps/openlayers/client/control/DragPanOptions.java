package org.gwtopenmaps.openlayers.client.control;


/**
 * @author Jon Britton
 *
 */
public class DragPanOptions extends ControlOptions
{

    public void setEnableKinetic(boolean enableKinetic)
    {
        getJSObject().setProperty("enableKinetic", enableKinetic);
    }
}
