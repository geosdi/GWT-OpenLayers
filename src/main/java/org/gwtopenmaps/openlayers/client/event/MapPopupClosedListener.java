package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * 
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapPopupClosedListener extends EventListener {

    class MapPopupClosedEvent extends EventObject{

        public MapPopupClosedEvent(JSObject eventObject) {
            super(eventObject);
        }

        //getPopup ???
    }
    
    public void onPopupClosed(Map source, MapPopupClosedEvent eventObject);
}
