package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface LayerLoadCancelListener extends EventListener {

    class LoadCancelEvent extends EventObject{

        public LoadCancelEvent(JSObject eventObject) {
            super(eventObject);
        }
        
    }
    
    public void onLoadCancel(Layer source, LoadCancelEvent eventObject);
}
