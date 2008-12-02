package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.feature.VectorFeature;
import com.eg.gwt.openLayers.client.layer.Vector;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorFeatureSelectedListener extends EventListener {

    class FeatureSelectedEvent extends EventObject{

        public FeatureSelectedEvent(JSObject eventObject) {
            super(eventObject);
        }
        
        public VectorFeature getFeature(){
            return super.getFeature();
        }
    }
    
    public void onFeatureSelected(Vector source, FeatureSelectedEvent eventObject);
}
