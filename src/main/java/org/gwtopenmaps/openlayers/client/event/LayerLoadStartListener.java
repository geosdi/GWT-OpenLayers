package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.layer.Layer;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface LayerLoadStartListener extends EventListener {

    class LoadStartEvent extends EventObject{

        public LoadStartEvent(JSObject eventObject) {
            super(eventObject);
        }
        
    }
    
    public void onLoadStart(Layer source, LoadStartEvent eventObject);
}
