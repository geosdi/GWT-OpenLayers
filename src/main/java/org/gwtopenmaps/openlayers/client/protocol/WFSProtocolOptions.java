package org.gwtopenmaps.openlayers.client.protocol;

import org.gwtopenmaps.openlayers.client.protocol.ProtocolOptions;

/**
 * WFSProtocolOptions
 *
 * @author davek<at>komacke<dot>com
 *
 */

public class WFSProtocolOptions extends ProtocolOptions {

	/**
	 * @param geometryName - set the geometry name
	 */
	public void setGeometryName(String geometryName){
		getJSObject().setProperty("geometryName",  geometryName);
	}

	/**
	 * @param url - the url of the WFS
	 */
	public void setUrl(String url){
		getJSObject().setProperty("url",  url);
	}
}
