package com.eg.gwt.openLayers.client.event;

import com.eg.gwt.openLayers.client.util.JSObject;

public class EventHandlerImpl {

    //Calling onXHandle on the abstract class XEventHandler will not work.
    //The ElementBridge can be passed a reference to the anonymously defined XEventHandler,
    //to call the onXHandle method implemented by that anonymous instance.
    public native static JSObject createHandler(EventHandler self)/*-{
        var handler = function(eo){
                var source = eo.object?eo.object:null;
                @com.eg.gwt.openLayers.client.event.EventHandlerBridge::onHandle(Lcom/eg/gwt/openLayers/client/util/JSObject;Lcom/eg/gwt/openLayers/client/util/JSObject;Lcom/eg/gwt/openLayers/client/event/EventHandler;)(source, eo, self);
            }
        return handler;
     }-*/;

}
