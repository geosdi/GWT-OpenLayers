package org.gwtopenmaps.openlayers.client.layer;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class BoxesImpl {

	public static native JSObject create(String name, JSObject options)/*-{
		return new $wnd.OpenLayers.Layer.Boxes(name, options);
	}-*/;
	
	public static native JSObject create(String name)/*-{
	    return new $wnd.OpenLayers.Layer.Boxes(name);
	}-*/;
}
