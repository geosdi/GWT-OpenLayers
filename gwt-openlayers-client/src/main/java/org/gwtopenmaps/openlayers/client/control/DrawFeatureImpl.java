/**
 *
 *   Copyright 2014 sourceforge.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
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

    /**
     * Finishes the sketch without including the currently drawn point.
     * This method can be called to terminate drawing programmatically instead of waiting for the user to end the sketch.
     * @param self self
     */
    public static native void finishSketch(JSObject self) /*-{
        self.finishSketch();
    }-*/;

}
