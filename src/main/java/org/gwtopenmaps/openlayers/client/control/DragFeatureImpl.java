package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class DragFeatureImpl {
	public static native JSObject create(JSObject layer)/*-{
	return new $wnd.OpenLayers.Control.DragFeature(layer);
    }-*/;


    public static native JSObject create(JSObject layer, JSObject options)/*-{
	return new $wnd.OpenLayers.Control.DragFeature(layer, options);
    }-*/;
	   
	   
}
