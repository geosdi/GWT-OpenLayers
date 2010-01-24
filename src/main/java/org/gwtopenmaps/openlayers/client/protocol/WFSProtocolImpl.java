package org.gwtopenmaps.openlayers.client.protocol;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * 
 * @author davek<at>komacke<dot>com
 *
 */

public class WFSProtocolImpl {

	public native static JSObject create(JSObject options)/*-{
		return new $wnd.OpenLayers.Protocol.WFS(options);
	}-*/;

	public native static JSObject create(JSObject layer, JSObject options)/*-{
		return new $wnd.OpenLayers.Protocol.WFS.fromWMSLayer(layer, options);
	}-*/;



}
