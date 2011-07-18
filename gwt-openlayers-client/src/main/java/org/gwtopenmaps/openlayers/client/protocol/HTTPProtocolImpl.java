/**
 * 
 */
package org.gwtopenmaps.openlayers.client.protocol;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * @author lorenzo
 *
 */
public class HTTPProtocolImpl {
	
	public native static JSObject create(JSObject options)/*-{
		return new $wnd.OpenLayers.Protocol.HTTP(options);
	}-*/;

	public native static void read(JSObject protocol, JSObject options)
	/*-{
		protocol.read(options);
	}-*/;
}
