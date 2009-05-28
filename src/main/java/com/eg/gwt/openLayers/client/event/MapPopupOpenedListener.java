package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.Map;
import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * 
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public interface MapPopupOpenedListener extends EventListener {

    class MapPopupOpenedEvent extends EventObject{

        public MapPopupOpenedEvent(JSObject eventObject) {
            super(eventObject);
        }

        //getPopup ???
    }
    
    public void onPopupOpened(Map source, MapPopupOpenedEvent eventObject);
}
