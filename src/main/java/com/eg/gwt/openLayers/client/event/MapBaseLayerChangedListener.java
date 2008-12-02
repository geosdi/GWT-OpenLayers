/**
 * 
 */
package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.Map;
import com.eg.gwt.openLayers.client.layer.Layer;

/**
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapBaseLayerChangedListener extends EventListener {

    class MapBaseLayerChangedEvent extends EventObject {

        public MapBaseLayerChangedEvent(JSObject eventObject) {
            super(eventObject);
        }
        
        public Layer getLayer(){
            return super.getLayer();
        }
    }
    
    public void onBaseLayerChanged(Map source, MapBaseLayerChangedEvent eventObject);
}
