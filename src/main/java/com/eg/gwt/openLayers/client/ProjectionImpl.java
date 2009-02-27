package com.eg.gwt.openLayers.client;

import com.eg.gwt.openLayers.client.util.JSObject;

public class ProjectionImpl {
	
	public static native JSObject create(String projection)/*-{
		return new $wnd.OpenLayers.Projection(projection);
	}-*/;

}
