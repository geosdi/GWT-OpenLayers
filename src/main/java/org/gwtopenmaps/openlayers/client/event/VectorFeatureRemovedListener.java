package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JSObject;

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
