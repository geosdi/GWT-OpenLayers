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

import org.gwtopenmaps.openlayers.client.Pixel;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * This control is used to handle drag and drop of the vector features of a
 * layer. Use the {@link DragFeatureOptions} to handle the events.
 *
 * @author Rafael Ceravolo - LOGANN
 */
public class DragFeature extends Control {

    /** Internal Constructor
     * @param dragFeatureObj
     */
    protected DragFeature(JSObject dragFeatureObj) {
        super(dragFeatureObj);
    }

    /**
     * Constructor.
     *
     * @param vectorLayer
     *            The layer that this DragFeature belongs.
     */
    public DragFeature(Vector vectorLayer) {
        this(DragFeatureImpl.create(vectorLayer.getJSObject()));
    }

    /**
     * Constructor.
     *
     * @param vectorLayer
     *            The layer that this DragFeature belongs.
     * @param options
     *            DragFeature options, used to set the listeners that handles
     *            the drag events
     */
    public DragFeature(Vector vectorLayer, DragFeatureOptions options) {
        this(DragFeatureImpl.create(vectorLayer.getJSObject(), options.getJSObject()));
    }

    /**
     * Set dragFeature.handlers['drag'].stopDown to a value
     * @param stopDown
     */
    public void setDragStopDown(boolean stopDown) {
        DragFeatureImpl.setDragStopDown(getJSObject(), stopDown);
    }

    /**
     * Set dragFeature.handlers['drag'].stopUp to a value
     * @param stopUp
     */
    public void setDragStopUp(boolean stopUp) {
        DragFeatureImpl.setDragStopUp(getJSObject(), stopUp);
    }

    /**
     * Set dragFeature.handlers['drag'].stopClick to a value
     * @param stopClick
     */
    public void setDragStopClick(boolean stopClick) {
        DragFeatureImpl.setDragStopClick(getJSObject(), stopClick);
    }

    /**
     * Set dragFeature.handlers['feature'].stopDown to a value
     * @param stopDown
     */
    public void setFeatureStopDown(boolean stopDown) {
        DragFeatureImpl.setFeatureStopDown(getJSObject(), stopDown);
    }

    /**
     * Set dragFeature.handlers['feature'].stopUp to a value
     * @param stopUp
     */
    public void setFeatureStopUp(boolean stopUp) {
        DragFeatureImpl.setFeatureStopUp(getJSObject(), stopUp);
    }

    /**
     * Set dragFeature.handlers['feature'].stopClick to a value
     * @param stopClick
     */
    public void setFeatureStopClick(boolean stopClick) {
        DragFeatureImpl.setFeatureStopClick(getJSObject(), stopClick);
    }

    /**
     * Listener for Drag events (Start, Drag and Complete)
     */
    public interface DragFeatureListener {

        void onDragEvent(VectorFeature vectorFeature, Pixel pixel);

    }

}
