package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface LayerVisibilityChangedListener extends EventListener {

    class VisibilityChangedEvent extends EventObject{

        public VisibilityChangedEvent(JSObject eventObject) {
            super(eventObject);
        }
        
    }
    
    public void onVisibilityChanged(Layer source, VisibilityChangedEvent eventObject);
}
