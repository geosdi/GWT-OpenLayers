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
		setFeatureNS(featureNS);
		setFeatureType(featureType);
	}
	
	/**
	 * @param geometryName - set the geometry name. Default is "the_geom".
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
	 * @param featureNS - Feature namespace
	 */
	public void setFeatureNS(String featureNS){
		getJSObject().setProperty("featureNS",  featureNS);
	}
	
	/**
	 * @param featureType - Local feature typeName
	 */
	public void setFeatureType(String featureType){
		getJSObject().setProperty("featureType",  featureType);
	}
	
}
