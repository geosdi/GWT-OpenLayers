package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.util.JSObject;

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
