package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.OpenLayersWidget;

public class EventListenerCollection {

    public void addListener(OpenLayersWidget w, String type, EventHandler handler){
        w.getEvents().register(type, w, handler);
    }

}
