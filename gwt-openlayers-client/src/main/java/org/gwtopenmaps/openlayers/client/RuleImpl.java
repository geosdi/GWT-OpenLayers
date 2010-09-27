package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 */
class RuleImpl {

	public static native JSObject create()/*-{
		return new $wnd.OpenLayers.Rule();
	}-*/;

	public static native JSObject create(JSObject options)/*-{
		return new $wnd.OpenLayers.Rule(options);
	}-*/;

}
