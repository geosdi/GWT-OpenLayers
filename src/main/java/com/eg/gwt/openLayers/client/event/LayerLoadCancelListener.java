package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.layer.Layer;
import com.eg.gwt.openLayers.client.util.JSObject;

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
