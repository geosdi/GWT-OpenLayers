package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.control.DrawFeature.FeatureAddedListener;
import org.gwtopenmaps.openlayers.client.util.JSObject;


/**
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class DrawFeatureImpl
{

    public static native JSObject create(JSObject layer, JSObject handler) /*-{
        return new $wnd.OpenLayers.Control.DrawFeature(layer, handler);
    }-*/;

    public static native JSObject create(JSObject layer, JSObject handler, JSObject options) /*-{
        return new $wnd.OpenLayers.Control.DrawFeature(layer, handler, options);
    }-*/;

    public static native JSObject createFeatureAddedCallback(FeatureAddedListener listener) /*-{
        var callback = function(obj){
        var vectorFeatureObj = @org.gwtopenmaps.openlayers.client.feature.VectorFeature::narrowToVectorFeature(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(obj);
        listener.@org.gwtopenmaps.openlayers.client.control.DrawFeature.FeatureAddedListener::onFeatureAdded(Lorg/gwtopenmaps/openlayers/client/feature/VectorFeature;)(vectorFeatureObj);
        }
        return callback;
    }-*/;

    public static native JSObject getHandler(JSObject control) /*-{
        return control.handler;
    }-*/;

    /**
     * Remove the most recently added point in the current sketch geometry.
     * @param self Self
     * @return true if an edit was undone.
     */
    public static native boolean undo(JSObject self) /*-{
       return self.undo();
    }-*/;

    /**
     * Reinsert the most recently removed point resulting from an undo call.  The undo stack is deleted whenever a point is added by other means.
     * @param self Self
     * @return true if an edit was redone.
     */
    public static native boolean redo(JSObject self) /*-{
       return self.redo();
    }-*/;

    /**
     * Cancel the current sketch.  This removes the current sketch and keeps the drawing control active.
     * @param self self
     */
    public static native void cancel(JSObject self) /*-{
        self.cancel();
    }-*/;
}
