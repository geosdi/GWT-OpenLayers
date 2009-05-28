package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * 
 * 
 * @author Edwin Commandeur - Atlis EJS
 *
 */
//TODO look if Marker Layer does not fire same event
//  if reason to fire event from map then explain in JavaDoc
public interface MapMarkerRemovedListener extends EventListener {

    class MapMarkerRemovedEvent extends EventObject{

        public MapMarkerRemovedEvent(JSObject eventObject) {
            super(eventObject);
        }

        //getMarker ???
    }
    
    public void onMarkerRemoved(Map source, MapMarkerRemovedEvent eventObject);
}
