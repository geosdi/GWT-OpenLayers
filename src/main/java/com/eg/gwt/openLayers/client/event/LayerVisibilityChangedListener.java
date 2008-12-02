package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.layer.Layer;

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
