package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.Map;
import com.eg.gwt.openLayers.client.util.JSObject;

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
