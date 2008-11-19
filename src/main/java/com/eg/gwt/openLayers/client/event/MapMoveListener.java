/**
 * 
 */
package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.JSObject;
import com.eg.gwt.openLayers.client.Map;

/**
 * Needs to be implemented to listen to map move events.
 * 
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapMoveListener extends EventListener {

    class MapMoveEvent extends EventObject {
        public MapMoveEvent(JSObject eventObject) {
            super(eventObject);
        }
    }
    
    void onMapMove(Map source, MapMoveEvent eventObject);

}
