package com.eg.gwt.openLayers.client.event;

import java.util.HashMap;
import java.util.Map;

import com.eg.gwt.openLayers.client.OpenLayersWidget;

/**
 * Registers listeners and keeps track of listener that are registered for events an object fires.
 * 
 * @author Edwin Commandeur - Atlis EJS
 *
 */
public class EventListenerCollection {

    private Map map = new HashMap();
    
    public void addListener(OpenLayersWidget w, EventListener listener, String type, EventHandler handler){
        //TODO check if type is defined and valid?
        w.getEvents().register(type, w, handler);
        addToCollection(listener, new ListenerRegisteredProperties(type, handler));
    }

    public void removeListener(OpenLayersWidget w, EventListener listener){
        ListenerRegisteredProperties props = getRegisteredProperties(listener);
        if(props!=null){
            w.getEvents().unregister(props.getType(), w, props.getEventHandler());
            removeRegisteredProperties(listener);
        }
        //TODO give feedback that listener is not in collection
    }

//EventListenerCollection is propery of widget, so removing all listeners
// means clearing the complete map (is calling map.clear() enough?)
/*
    public void removeListeners(OpenLayersWidget w){
        int size = map.size();
        if(size > 0){
            for(int i = 0;i< size;i++){
                
            }
        }
    }
*/    
    private void addToCollection(EventListener listener, ListenerRegisteredProperties props){
        map.put(listener, props);
    }
    
    private ListenerRegisteredProperties getRegisteredProperties(EventListener listener){
        return (ListenerRegisteredProperties) map.get(listener);
    }

    private void removeRegisteredProperties(EventListener listener){
        map.remove(listener);
    }
    
    
    private class ListenerRegisteredProperties {
        String type;
        EventHandler handler;
        
        ListenerRegisteredProperties(String type, EventHandler handler){
            this.type = type;
            this.handler = handler;
        }
        
        String getType(){
            return this.type;
        }
        
        EventHandler getEventHandler(){
            return this.handler;
        }
    }
}
