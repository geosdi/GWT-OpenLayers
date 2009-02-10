package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.layer.Layer;
import com.eg.gwt.openLayers.client.util.JSObject;

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
