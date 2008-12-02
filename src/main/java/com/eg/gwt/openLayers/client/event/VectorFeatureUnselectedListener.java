package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.feature.VectorFeature;
import com.eg.gwt.openLayers.client.layer.Vector;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorFeatureUnselectedListener extends EventListener {

    class FeatureUnselectedEvent extends EventObject{

        public FeatureUnselectedEvent(JSObject eventObject) {
            super(eventObject);
        }
        
        public VectorFeature getFeature(){
            return super.getFeature();
        }
    }
    
    public void onFeatureUnselected(Vector source, FeatureUnselectedEvent eventObject);
}
