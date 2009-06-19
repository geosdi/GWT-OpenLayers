package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class EventHandlerImpl {

	public native static JSObject createHandler(EventHandler self)/*-{
		var handler = function(eo){
				self.@org.gwtopenmaps.openlayers.client.event.EventHandler::onHandle(Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(eo);
		}
		return handler;
	 }-*/;

}
