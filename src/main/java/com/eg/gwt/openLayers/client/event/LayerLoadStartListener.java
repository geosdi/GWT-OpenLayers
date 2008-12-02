package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.layer.Layer;

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
