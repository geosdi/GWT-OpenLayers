package org.gwtopenmaps.openlayers.client.control;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * 
 * @author davek<at>komacke<dot>com
 *
 */

public class GetFeatureImpl {

	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Control.GetFeature();
	}-*/;

	public static native JSObject create(JSObject options)/*-{
		return new $wnd.OpenLayers.Control.GetFeature(options);
	}-*/;

}
