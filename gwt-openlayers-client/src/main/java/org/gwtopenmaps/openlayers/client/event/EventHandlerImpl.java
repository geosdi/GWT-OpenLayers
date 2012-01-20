package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;


public class EventHandlerImpl
{

    public static native JSObject createHandler(EventHandler self) /*-{
        var handler = function(eo){
        var eventObject = @org.gwtopenmaps.openlayers.client.event.EventObject::narrowToEventObject(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(eo);
        self.@org.gwtopenmaps.openlayers.client.event.EventHandler::onHandle(Lorg/gwtopenmaps/openlayers/client/event/EventObject;)(eventObject);
        }
        return handler;
    }-*/;

}
