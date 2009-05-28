package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.feature.VectorFeature;
import com.eg.gwt.openLayers.client.layer.Vector;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorFeatureModifiedListener extends EventListener {

    class FeatureModifiedEvent extends EventObject{

        public FeatureModifiedEvent(JSObject eventObject) {
            super(eventObject);
        }

        public VectorFeature getFeature(){
            return super.getFeature();
        }
    }
    
    public void onFeatureModified(Vector source, FeatureModifiedEvent eventObject);
}
