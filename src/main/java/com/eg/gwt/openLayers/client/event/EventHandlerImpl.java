package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.util.JSObject;

public class EventHandlerImpl {

    public native static JSObject createHandler(EventHandler self)/*-{
        var handler = function(eo){
                var source = eo.object?eo.object:null;
                self.@com.eg.gwt.openLayers.client.event.EventHandler::onHandle(Lcom/eg/gwt/openLayers/client/util/JSObject;Lcom/eg/gwt/openLayers/client/util/JSObject;)(source, eo);
            }
        return handler;
     }-*/;

}
