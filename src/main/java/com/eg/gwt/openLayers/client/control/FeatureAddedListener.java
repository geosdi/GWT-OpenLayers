package com.eg.gwt.openLayers.client.control;

import com.eg.gwt.openLayers.client.JSObject;

/**
 * Listener that listens to firing of featureAdded handler.
 * In javascript the handler can be attached to the DrawFeature control.
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
    void onFeatureAdded(JSObject vectorFeature);
}
