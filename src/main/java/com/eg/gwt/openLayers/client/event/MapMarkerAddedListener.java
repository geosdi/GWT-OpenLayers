package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.Map;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * 
 * 
 * @author Edwin Commandeur - Atlis EJS
 *
 */
//TODO look if Marker Layer does not fire same event
//  if reason to fire event from map then explain in JavaDoc
public interface MapMarkerAddedListener extends EventListener {

    class MapMarkerAddedEvent extends EventObject{

        public MapMarkerAddedEvent(JSObject eventObject) {
            super(eventObject);
        }

        //getMarker ???
    }
    
    public void onMarkerAdded(Map source, MapMarkerAddedEvent eventObject);
}
