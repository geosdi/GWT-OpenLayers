package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.layer.Layer;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface LayerLoadEndListener extends EventListener {

    class LoadEndEvent extends EventObject{

        public LoadEndEvent(JSObject eventObject) {
            super(eventObject);
        }
        
    }
    
    public void onLoadEnd(Layer source, LoadEndEvent eventObject);
}
