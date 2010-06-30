package org.gwtopenmaps.openlayers.client.protocol;

import org.gwtopenmaps.openlayers.client.util.JSObject;

public class ResponseImpl {

	public static native JSObject getFeatures(JSObject response)
	/*-{
		return response.features;
	}-*/;

}
