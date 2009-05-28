/**
 * 
 */
package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.Map;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * Needs to be implemented to listen to map zoom events.
 * 
 * @author Curtis Jensen
 *
 */
public interface MapZoomListener extends EventListener {

    class MapZoomEvent extends EventObject {
        public MapZoomEvent(JSObject eventObject) {
            super(eventObject);
        }
    }
    
    void onMapZoom(Map source, MapZoomEvent eventObject);

}
