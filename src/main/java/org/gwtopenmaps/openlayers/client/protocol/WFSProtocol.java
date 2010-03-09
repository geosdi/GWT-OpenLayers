package org.gwtopenmaps.openlayers.client.protocol;

import org.gwtopenmaps.openlayers.client.layer.WMS;

/**
 * 
 * WFS Protocol for Vector Layers - intentionally deviates from OpenLayers name.  This is
 * basically OpenLayers.Protocol.WFS
 * 
 * @author davek<at>komacke<dot>com
 * @author Mikael Couzic
 */

public class WFSProtocol extends Protocol {

	/**
	 * @param options - WFSProtocolOptions used to configure this protocol 
	 * @return WFSProtocol object 
	 */
	public WFSProtocol(WFSProtocolOptions options) {
		super(WFSProtocolImpl.create(options.getJSObject()));
	}

	/**
	 * Implements the convenience method OpenLayers.Protocol.WFS.fromWMSLayer().  Since
	 * it's really a constructor we'll call it the proper java constructor name
	 * with a layer object.
	 * 
	 * The convenience method uses a WMS Layer to populate a bunch of values under
	 * the assumption that the WFS query will be done to the same layer at the server
	 * 
	 * @param layer - WMS Layer to get properties from to configure protocol
	 * @param options - WFSProtocolOptions used to configure this protocol 
	 * @return WFSProtocol object
	 */
	public WFSProtocol(WMS layer, WFSProtocolOptions options) {
		super(WFSProtocolImpl.create(layer.getJSObject(), options.getJSObject()));
	}
	
	/**
	 * Performs a GetFeature request on the WFS service.
	 * 
	 * Due to the asymetric callback system, the return type of the method has been set to void.
	 * The results are accessed by the <code>Callback.computeResult()</code> method.
	 *
	 * @param options - Options object, encapsulating the callback
	 */
	public void read(CRUDOptions options) {
		WFSProtocolImpl.read(this.getJSObject(), options.getJSObject());
	}
	
}
