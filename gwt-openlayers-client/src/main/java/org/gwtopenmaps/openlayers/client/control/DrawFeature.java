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

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.handler.Handler;
import org.gwtopenmaps.openlayers.client.handler.chain.ChainHandlerManager;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * Don't be suprised by the following: Upon activating the DrawFeature tool it
 * creates an extra layer that is used by the handler (the name of this layer
 * reflects this).
 *
 * (tested in OpenLayers 2.7)
 *
 * @author Erdem Gunay
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class DrawFeature extends Control {

    static {
        chainHandlerManager = new ChainHandlerManager();
    }

    private static final ChainHandlerManager chainHandlerManager;

    protected DrawFeature(JSObject element) {
        super(element);
    }

    /**
     *
     * @param layer
     * @param handler - a PointHandler, PathHandler or PolygonHandler
     */
    public DrawFeature(Vector layer, Handler handler) {
        this(DrawFeatureImpl.create(layer.getJSObject(), handler.getJSObject()));
    }

    /**
     *
     * @param layer
     * @param handler - a PointHandler, PathHandler or PolygonHandler
     * @param options - see {@link DrawFeatureOptions}
     */
    public DrawFeature(Vector layer, Handler handler, DrawFeatureOptions options) {
        this(DrawFeatureImpl.create(layer.getJSObject(), handler.getJSObject(),
                options.getJSObject()));
    }

    /**
     * This method returns the Handler associated to the control. The CLASS_NAME
     * of the handler depends on the kind of control.
     *
     * @return Handler
     */
    public <H extends Handler> H getHandler() {
        return chainHandlerManager.buildHandler(DrawFeatureImpl.getHandler(
                getJSObject()));
    }

    public interface FeatureAddedListener {

        void onFeatureAdded(VectorFeature vectorFeature);

    }

    /**
     * Remove the most recently added point in the current sketch geometry.
     *
     * @return true if an edit was undone.
     */
    public boolean undo() {
        return DrawFeatureImpl.undo(getJSObject());
    }

    /**
     * Reinsert the most recently removed point resulting from an undo call. The
     * undo stack is deleted whenever a point is added by other means.
     *
     * @return true if an edit was redone.
     */
    public boolean redo() {
        return DrawFeatureImpl.redo(getJSObject());
    }

    /**
     * Cancel the current sketch. This removes the current sketch and keeps the
     * drawing control active.
     */
    public void cancel() {
        DrawFeatureImpl.cancel(getJSObject());
    }

    /**
     * Finishes the sketch without including the currently drawn point.
     * This method can be called to terminate drawing programmatically instead of waiting for the user to end the sketch.
     */
    public void finishSketch() {
        DrawFeatureImpl.finishSketch(getJSObject());
    }

}