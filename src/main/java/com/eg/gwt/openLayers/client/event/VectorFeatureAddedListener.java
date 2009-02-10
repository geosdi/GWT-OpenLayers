package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.feature.VectorFeature;
import com.eg.gwt.openLayers.client.layer.Vector;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorFeatureAddedListener extends EventListener {

    class FeatureAddedEvent extends EventObject{

        public FeatureAddedEvent(JSObject eventObject) {
            super(eventObject);
        }
        
        public VectorFeature getFeature(){
            return super.getFeature();
        }
    }
    
    public void onFeatureAdded(Vector source, FeatureAddedEvent eventObject);
}
