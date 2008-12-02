package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.feature.VectorFeature;
import com.eg.gwt.openLayers.client.layer.Vector;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface VectorFeatureRemovedListener extends EventListener {

    class FeatureRemovedEvent extends EventObject{

        public FeatureRemovedEvent(JSObject eventObject) {
            super(eventObject);
        }
        
        public VectorFeature getFeature(){
            return super.getFeature();
        }
    }
    
    public void onFeatureRemoved(Vector source, FeatureRemovedEvent eventObject);
}
