package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.layer.Layer;

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
