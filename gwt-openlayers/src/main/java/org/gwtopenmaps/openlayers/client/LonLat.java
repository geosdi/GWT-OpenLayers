package org.gwtopenmaps.openlayers.client;

import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 * Represents a longitude, latitude coordinate pair.
 * 
 * Longitude: east-west geographic coordinate.
 * Latitude: south-north geographic coordinate. 
 * 
 * @author Erdem Gunay
 *
 */
public class LonLat extends OpenLayersObjectWrapper {

	protected LonLat(JSObject element) {
		super(element);
	}

	public static LonLat narrowToLonLat(JSObject element)
	{
		return (element == null)?null:new LonLat(element);
	}
	
	public LonLat(double lon, double lat) {
		this (LonLatImpl.create(lon, lat));
	}
	
	public double lon() {
		return LonLatImpl.lon(getJSObject());
	}

	public double lat() {
		return LonLatImpl.lat(getJSObject());
	}
	
	public void transform(String src, String dst){
		LonLatImpl.transform(getJSObject(), src, dst);
	}
	
}
