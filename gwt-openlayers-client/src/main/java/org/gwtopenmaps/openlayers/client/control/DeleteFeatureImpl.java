package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class DeleteFeatureImpl {
	public native static JSObject create(JSObject vector) /*-{
		return new $wnd.OpenLayers.Control.DeleteFeature(vector);
	}-*/;
}
