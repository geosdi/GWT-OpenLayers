package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.Map;
import com.eg.gwt.openLayers.client.layer.Layer;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapLayerAddedListener extends EventListener {

    class MapLayerAddedEvent extends EventObject{

        public MapLayerAddedEvent(JSObject eventObject) {
            super(eventObject);
        }
        
        public Layer getLayer() {
            return super.getLayer();
        }
    }
    
    public void onLayerAdded(Map source, MapLayerAddedEvent eventObject);
}
