package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.handler.Handler;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 *  Don't be suprised by the following:
 *  Upon activating the DrawFeature tool it creates an extra layer
 *  that is used by the handler (the name of this layer reflects this).
 *
 * (tested in OpenLayers 2.7)
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class DrawFeature extends Control
{

    protected DrawFeature(JSObject element)
    {
        super(element);
    }

    /**
     *
     * @param layer
     * @param handler - a PointHandler, PathHandler or PolygonHandler
     */
    public DrawFeature(Vector layer, Handler handler)
    {
        this(DrawFeatureImpl.create(layer.getJSObject(), handler.getJSObject()));
    }

    /**
     *
     * @param layer
     * @param handler - a PointHandler, PathHandler or PolygonHandler
     * @param options - see {@link DrawFeatureOptions}
     */
    public DrawFeature(Vector layer, Handler handler, DrawFeatureOptions options)
    {
        this(DrawFeatureImpl.create(layer.getJSObject(), handler.getJSObject(), options.getJSObject()));
    }

    /**
     * This method returns the Handler associated to the control. The CLASS_NAME
     * of the handler depends on the kind of control.
     *
     * @return Handler
     */
    public Handler getHandler()
    {
        return Handler.narrowToHandler(DrawFeatureImpl.getHandler(getJSObject()));
    }

    public interface FeatureAddedListener
    {
        void onFeatureAdded(VectorFeature vectorFeature);
    }

    /**
     * Remove the most recently added point in the current sketch geometry.
     * @return true if an edit was undone.
     */
    public boolean undo()
    {
        return DrawFeatureImpl.undo(getJSObject());
    }

    /**
     * Reinsert the most recently removed point resulting from an undo call.  The undo stack is deleted whenever a point is added by other means.
     * @return true if an edit was redone.
     */
    public boolean redo()
    {
        return DrawFeatureImpl.redo(getJSObject());
    }

    /**
     * Cancel the current sketch.  This removes the current sketch and keeps the drawing control active.
     */
    public void cancel()
    {
        DrawFeatureImpl.cancel(getJSObject());
    }
}