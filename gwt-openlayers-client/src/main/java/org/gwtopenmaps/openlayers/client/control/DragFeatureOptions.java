package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.control.DragFeature.DragFeatureListener;
import org.gwtopenmaps.openlayers.client.util.JSObject;
import org.gwtopenmaps.openlayers.client.util.JStringArray;


/**
 * Options for the DragFeature. Use this to set the listeners that will handle
 * the drag events.
 *
 * @author Rafael Ceravolo - LOGANN
 * @author Jon Britton - SpiffyMap Ltd
 */
public class DragFeatureOptions extends ControlOptions
{
    /**
     * To restrict dragging to a limited set of geometry types, send a list of strings 
     * corresponding to the geometry class names (from OL docs).
     * @param geometryTypes 
     */
    public void setGeometryTypes(String[] geometryTypes) 
    {
        JStringArray array = JStringArray.create(geometryTypes);
		getJSObject().setProperty("geometryTypes", array.getJSObject());
    }
    
    /**
     * If set to true, mouse dragging will continue even if the mouse cursor leaves the 
     * map viewport (from OL docs).
     * @param documentDrag 
     */
    public void setDocumentDrag(boolean documentDrag) 
    {
        getJSObject().setProperty("documentDrag", documentDrag);
    }
    
    /**
     * Triggers when a feature has just started being dragged.
     * @param listener 
     */
    public void onStart(DragFeatureListener listener)
    {
        createAndSetCallback(listener, "onStart");
    }

    /**
     * Continually trigged while a feature is being dragged.
     * @param listener 
     */
    public void onDrag(DragFeatureListener listener)
    {
        createAndSetCallback(listener, "onDrag");
    }

    /**
     * Triggers when a feature completed dragged (the users releases the mouse).
     * @param listener 
     */
    public void onComplete(DragFeatureListener listener)
    {
        createAndSetCallback(listener, "onComplete");
    }

    /** Creates a JS callback for a event type */
    private void createAndSetCallback(DragFeatureListener listener, String name)
    {
        JSObject callback = DragFeatureImpl.createDragCallback(listener);
        getJSObject().setProperty(name, callback);
    }

}
