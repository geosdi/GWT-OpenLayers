/**
 * 
 */
package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.Map;
import com.eg.gwt.openLayers.client.layer.Layer;

/**
 * Listens to 'changelayer' event that fires on:
 *  a name change, an order change, or a visibility change of a layer
 *  
 * Listening to visibility changes can be done at the layer level
 * with a LayerVisibilityChangedListener.
 * 
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapLayerChangedListener extends EventListener {

    class MapLayerChangedEvent extends EventObject {

        public MapLayerChangedEvent(JSObject eventObject) {
            super(eventObject);
        }
        
        public Layer getLayer(){
            return super.getLayer();
        }
    }
    
    public void onLayerChanged(Map source, MapLayerChangedEvent eventObject);
}
