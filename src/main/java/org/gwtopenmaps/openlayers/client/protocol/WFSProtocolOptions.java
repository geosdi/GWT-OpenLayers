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

	/**
	 * @param feature namespace - the namespace of the feature schema
	 */
	public void setFeatureNameSpace(String featureNS){
		getJSObject().setProperty("featureNS", featureNS);
	}

	/**
	 * @param feature type - the type of feature, for example: roads, lakes, cities
	 */
	public void setFeatureType(String featureType){
		getJSObject().setProperty("featureType", featureType);
	}
}
