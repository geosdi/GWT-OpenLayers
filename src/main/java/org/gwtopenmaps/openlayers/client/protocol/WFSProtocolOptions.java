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
	 * This constructor doesn't allow proper use of method <code>WFSProtocol.read()</code>.
	 * Use <code>WFSProtocolOptions(String url, String featureNS, String featureType )</code> instead.
	 */
	public WFSProtocolOptions(){}
	
	public WFSProtocolOptions(String url, String featureNS, String featureType ){
		setUrl(url);
		setFeatureNameSpace(featureNS);
		setFeatureType(featureType);
	}
	
	/**
	 * @param geometryName - set the geometry name. Default is "the_geom".
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
