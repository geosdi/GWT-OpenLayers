package com.eg.gwt.openLayers.client;

import com.eg.gwt.openLayers.client.event.EventHandler;

public class ElementBridge {

	public static void onHandle(JSObject source, JSObject args, EventHandler handler)
	{
		handler.onHandle(source, (args==null)?null:new JObjectArray(args).toArray());
	}
	
}
