package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.control.DragFeature.DragFeatureListener;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 * Options for the DragFeature. Use this to set the listeners that will handle
 * the drag events.
 *
 * @author Rafael Ceravolo - LOGANN
 */
public class DragFeatureOptions extends ControlOptions
{

    /**
     * Triggers when a feature has just started being dragged
     */
    public void onStart(DragFeatureListener listener)
    {
        createAndSetCallback(listener, "onStart");
    }

    /**
     * Continually trigged while a feature is being dragged
     */
    public void onDrag(DragFeatureListener listener)
    {
        createAndSetCallback(listener, "onDrag");
    }

    /**
     * Triggers when a feature completed dragged (the users releases the mouse).
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
