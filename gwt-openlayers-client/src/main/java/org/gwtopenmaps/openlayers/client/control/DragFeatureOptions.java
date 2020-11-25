/*
 *
 *   Copyright 2015 GWT OpenLayers Team.
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
public class DragFeatureOptions extends ControlOptions {

    /**
     * To restrict dragging to a limited set of geometry types, send a list of strings 
     * corresponding to the geometry class names (from OL docs).
     * @param geometryTypes 
     */
    public void setGeometryTypes(String[] geometryTypes) {
        JStringArray array = JStringArray.create(geometryTypes);
        getJSObject().setProperty("geometryTypes", array.getJSObject());
    }

    /**
     * If set to true, mouse dragging will continue even if the mouse cursor leaves the 
     * map viewport (from OL docs).
     * @param documentDrag 
     */
    public void setDocumentDrag(boolean documentDrag) {
        getJSObject().setProperty("documentDrag", documentDrag);
    }

    /**
     * Triggers when a feature has just started being dragged.
     * @param listener 
     */
    public void onStart(DragFeatureListener listener) {
        createAndSetCallback(listener, "onStart");
    }

    /**
     * Continually trigged while a feature is being dragged.
     * @param listener 
     */
    public void onDrag(DragFeatureListener listener) {
        createAndSetCallback(listener, "onDrag");
    }

    /**
     * Triggers when a feature completed dragged (the users releases the mouse).
     * @param listener 
     */
    public void onComplete(DragFeatureListener listener) {
        createAndSetCallback(listener, "onComplete");
    }

    /** Creates a JS callback for a event type */
    private void createAndSetCallback(DragFeatureListener listener, String name) {
        JSObject callback = DragFeatureImpl.createDragCallback(listener);
        getJSObject().setProperty(name, callback);
    }

}
