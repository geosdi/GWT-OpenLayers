package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * TODO: nest this interface under control ...
 *
 * Listens to firing of featureAdded handler.
 *
 * The featureAdded handler is invoked by the DrawFeature control.
 *
 * @author Edwin Commandeur - Atlis EJS
 *
 * Example of use:
 *      FeatureAddedListener listener = new FeatureAddedListener(){
 *           public void onFeatureAdded(JSObject vectorFeature) {
 *                VectorFeature vf = VectorFeature.narrowToVectorFeature(vectorFeature);
 *                Window.alert("Feature of class " + vf.getGeometryClassName() +  " added!");
 *          }
 *      }
 *      DrawFeature drawPolygon = new DrawFeature(vectorLayer, polygonHandler, listener);
 */
public interface FeatureAddedListener {

    //TODO: can this be refactored along the lines of MapMoveListener etc.?
    class FeatureAddedEvent{

    }

    void onFeatureAdded(JSObject vectorFeature);
}
