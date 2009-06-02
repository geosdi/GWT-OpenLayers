package org.gwtopenmaps.openlayers.client.event;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class EventHandlerImpl {

	public native static JSObject createHandler(EventHandler self)/*-{
		var handler = function(eo){
				var source = eo.object?eo.object:null;
				self.@org.gwtopenmaps.openlayers.client.event.EventHandler::onHandle(Lorg/gwtopenmaps/openlayers/client/util/JSObject;Lorg/gwtopenmaps/openlayers/client/util/JSObject;)(source, eo);
			}
		return handler;
	 }-*/;

}
