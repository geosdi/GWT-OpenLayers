/**
 * 
 */
package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.util.JSObject;

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
