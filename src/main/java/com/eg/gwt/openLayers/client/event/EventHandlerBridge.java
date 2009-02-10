package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.util.JSObject;

/**
 * Helper class to call the onHandle method on an anonymous EventHandler implementation. 
 * 
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class EventHandlerBridge {

    public static void onHandle(JSObject source, JSObject eventObject, EventHandler handler)
    {
        handler.onHandle(source, eventObject);
    }
    
}
