package org.gwtopenmaps.openlayers.client.control;


/**
 * @author Jon Britton - SpiffyMap Ltd
 *
 */
public class DragPanOptions extends ControlOptions
{

    public void setEnableKinetic(boolean enableKinetic)
    {
        getJSObject().setProperty("enableKinetic", enableKinetic);
    }
    
    public void setDocumentDrag(boolean documentDrag) 
    {
        getJSObject().setProperty("documentDrag", documentDrag);
    }
    
    public void setKineticInterval(int kineticInterval) 
    {
        getJSObject().setProperty("kineticInterval", kineticInterval);
    }
}
