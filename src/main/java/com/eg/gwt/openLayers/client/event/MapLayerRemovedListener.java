package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.Map;
import com.eg.gwt.openLayers.client.layer.Layer;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapLayerRemovedListener extends EventListener {

    class MapLayerRemovedEvent extends EventObject{

        public MapLayerRemovedEvent(JSObject eventObject) {
            super(eventObject);
        }
        
        public Layer getLayer() {
            return super.getLayer();
        }
    }
    
    public void onLayerRemoved(Map source, MapLayerRemovedEvent eventObject);
}
